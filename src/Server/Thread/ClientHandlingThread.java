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
                    if (msg.equals("LOGOUT")){
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
                        if(msg.equals("ENTRY")){
                            Date date = new Date();
                            dataPackage.put("dateCreated", date);
                            dataPackage.put("centreCode", centre.getCentreCode());
                            Customer customer = Customer.toCustomer(dataPackage);
                            serviceManager.getCustManagerService().insert(customer);
                        }
                        break;
                    }
                }
            } catch (    IOException | ClassNotFoundException ex) {
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
