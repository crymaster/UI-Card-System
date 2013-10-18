/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Server.Thread;

import Server.Entity.Employee;
import Server.Service.ServiceManager;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Son
 */
public class ClientHandlingThread extends Thread {

    private Socket socket = null;
    private ObjectInputStream input = null;
    private ObjectOutputStream output = null;
    private ServiceManager serviceManager;
    private int step;

    public ClientHandlingThread(Socket socket) {
        this.socket = socket;
        step = 0;
        serviceManager = new ServiceManager();
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
                        output.writeObject("CLOSE");
                        this.close();
                        break;
                    }
                }
                switch (step) {
                    case 0: {
                        HashMap empData = (HashMap) data;
                        Employee employee = new Employee();
                        employee.setEmpName((String)empData.get("empName"));
                        employee.setPassword((String)empData.get("password"));
                        employee = serviceManager.getEmpManagerService().authenticate(employee);
                        if(employee!= null){
                            empData = employee.toHashMap();
                            this.write(empData);
                        }else{
                            this.write("ERROR");
                        }
                    }
                    break;
                }
            } catch (IOException ex) {
                Logger.getLogger(ClientHandlingThread.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ClientHandlingThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        close();
    }

    public void write(Object data){
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
