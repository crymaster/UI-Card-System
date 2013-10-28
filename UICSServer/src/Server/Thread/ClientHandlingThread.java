/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Server.Thread;

import Server.Entity.Centre;
import Server.Entity.Customer;
import Server.Entity.Employee;
import Server.Service.ServiceManager;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Son
 */
public class ClientHandlingThread extends Thread {

    public static final int LOGGING_PHASE = 0;
    public static final int ENTRY_PHASE = 1;
    public static final int UI_PHASE = 2;
    private Socket socket = null;
    private ObjectInputStream input = null;
    private ObjectOutputStream output = null;
    private ServiceManager serviceManager;
    private Centre centre;
    private int step;

    public ClientHandlingThread(Socket socket) {
        this.socket = socket;
        step = LOGGING_PHASE;
        serviceManager = new ServiceManager();
        //Get client address and check in database if this ip belong to a centre
        InetAddress ia = socket.getInetAddress();
        String ip = ia.getHostAddress();
        centre = this.serviceManager.getCentreManagerService().getByIp(ip);
        try {
            output = new ObjectOutputStream(socket.getOutputStream());
            input = new ObjectInputStream(socket.getInputStream());
        } catch (IOException ex) {
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                //Listen to client
                Object data = input.readObject();
                if (data instanceof String) {
                    String msg = (String) data;
                    if (msg.equals("CLOSE")) {
                        this.close();
                        break;
                    }
                    if (msg.equals("LOGOUT")) {
                        //back to 1st phase
                        step = LOGGING_PHASE;
                        continue;
                    }
                }
                switch (step) {
                    //LOGGING_PHASE
                    case 0: {
                        //Convert to employee object and authenticate in database
                        HashMap empData = (HashMap) data;
                        Employee employee = new Employee();
                        employee.setEmpName((String) empData.get("empName"));
                        employee.setPassword((String) empData.get("password"));
                        employee = serviceManager.getEmpManagerService().authenticate(employee);
                        //Employee valid and belong to right centre
                        if (employee != null && this.centre != null && employee.getCentreCode().equals(this.centre.getCentreCode())) {
                            empData = employee.toHashMap();
                            this.write(empData);
                            //to 2nd phase
                            step = ENTRY_PHASE;
                        } else {
                            this.write("ERROR");
                        }
                        break;
                    }
                    //ENTRY_PHASE
                    case 1: {
                        HashMap dataPackage = (HashMap) data;
                        String msg = (String) dataPackage.get("message");
                        //begin entry process
                        if (msg.equals("ENTRY")) {
                            //convert data to customer object
                            Customer customer = Customer.toCustomer(dataPackage);
                            //add centreCode, status and created date
                            customer.setCentreCode(centre.getCentreCode());
                            Date date = new Date();
                            customer.setDateCreated(date);
                            customer.setStatus(-1);
                            //generate unique code
                            customer = serviceManager.getCustManagerService().generateUICode(customer);
                            //insert to database
                            if (serviceManager.getCustManagerService().insert(customer)) {
                                dataPackage = customer.toHashMap();
                                dataPackage.put("message", "ENTRYSUCCESS");
                                this.write(dataPackage);
                                step = UI_PHASE;
                            } else {
                                dataPackage.put("message", "ENTRYFAIL");
                                this.write(dataPackage);
                            }
                        }
                        //Update employee profile
                        if (msg.equals("PROFILE")) {
                            //convert data to employee object
                            Employee employee = Employee.toEmployee(dataPackage);
                            Employee temp = serviceManager.getEmpManagerService().getByEmpName(employee.getEmpName());
                            //check if employee name exists or stil lthe same
                            if (temp == null || temp.getEmpID() == employee.getEmpID()) {
                                if (serviceManager.getEmpManagerService().save(employee)) {
                                    dataPackage.put("message", "PROFILESUCCESS");
                                    this.write(dataPackage);
                                } else {
                                    dataPackage.put("message", "PROFILEFAIL");
                                    this.write(dataPackage);
                                }
                            } else {
                                dataPackage.put("message", "PROFILEFAIL");
                                this.write(dataPackage);
                            }
                        }
                        break;
                    }
                    //UI_PHASE
                    case 2: {
                        //convert data to customer
                        HashMap dataPackage = (HashMap) data;
                        Customer customer = Customer.toCustomer(dataPackage);
                        customer.setStatus(0);
                        //update customer
                        if (serviceManager.getCustManagerService().updateByUICode(customer)) {
                            this.write("UISUCCESS");
                            step = ENTRY_PHASE;
                        } else {
                            this.write("UIFAIL");
                        }
                        break;
                    }
                }
            } catch (IOException | ClassNotFoundException ex) {
                break;
            }
        }
        close();
    }

    public void write(Object data) {
        try {
            output.writeObject(data);
        } catch (IOException ex) {
        }
    }

    public void close() {
        try {
            if (output != null) {
                output.close();
            }
        } catch (Exception e) {
        }
        try {
            if (input != null) {
                input.close();
            }
        } catch (Exception e) {
        };
        try {
            if (socket != null) {
                socket.close();
            }
        } catch (Exception e) {
        }
    }
}
