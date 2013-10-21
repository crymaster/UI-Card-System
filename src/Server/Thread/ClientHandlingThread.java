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
        InetAddress ia = socket.getInetAddress();
        String ip = ia.getHostAddress();
        centre = this.serviceManager.getCentreManagerService().getByIp(ip);
        try {
            output = new ObjectOutputStream(socket.getOutputStream());
            input = new ObjectInputStream(socket.getInputStream());
        } catch (IOException ex) {
            Logger.getLogger(ClientHandlingThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                Object data = input.readObject();
                if (data instanceof String) {
                    String msg = (String) data;
                    if (msg.equals("CLOSE")) {
                        this.close();
                        break;
                    }
                    if (msg.equals("LOGOUT")) {
                        step = LOGGING_PHASE;
                        continue;
                    }
                }
                switch (step) {
                    case 0: {
                        HashMap empData = (HashMap) data;
                        Employee employee = new Employee();
                        employee.setEmpName((String) empData.get("empName"));
                        employee.setPassword((String) empData.get("password"));
                        employee = serviceManager.getEmpManagerService().authenticate(employee);
                        if (employee != null && employee.getCentreCode().equals(this.centre.getCentreCode())) {
                            empData = employee.toHashMap();
                            this.write(empData);
                            step = ENTRY_PHASE;
                        } else {
                            this.write("ERROR");
                        }
                        break;
                    }
                    case 1: {
                        HashMap dataPackage = (HashMap) data;
                        String msg = (String) dataPackage.get("message");
                        if (msg.equals("ENTRY")) {
                            Customer customer = Customer.toCustomer(dataPackage);
                            customer.setCentreCode(centre.getCentreCode());
                            Date date = new Date();
                            customer.setDateCreated(date);
                            customer.setStatus(-1);
                            customer = serviceManager.getCustManagerService().generateUICode(customer);
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
                        if (msg.equals("PROFILE")) {
                            Employee employee = Employee.toEmployee(dataPackage);
                            Employee temp = serviceManager.getEmpManagerService().getByEmpName(employee.getEmpName());
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
                    case 2: {
                        HashMap dataPackage = (HashMap) data;
                        Customer customer = Customer.toCustomer(dataPackage);
                        customer.setStatus(0);
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
            Logger.getLogger(ClientHandlingThread.class.getName()).log(Level.SEVERE, null, ex);
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
