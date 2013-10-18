/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Client.Connection;

import Client.Controller.ControllerManager;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Son
 */
public class ListeningThread implements Runnable {

    private ObjectInputStream input;
    private ServerConnection connection;
    private ControllerManager controllerManager;
    private int step;

    public ListeningThread() {
        step = 0;
    }

    public ServerConnection getConnection() {
        return connection;
    }

    public void setConnection(ServerConnection connection) {
        this.connection = connection;
    }

    public ControllerManager getControllerManager() {
        return controllerManager;
    }

    public void setControllerManager(ControllerManager controllerManager) {
        this.controllerManager = controllerManager;
    }

    public ObjectInputStream getInput() {
        return input;
    }

    public void setInput(ObjectInputStream input) {
        this.input = input;
    }

    public void close() {
        if (input != null) {
            try {
                input.close();
            } catch (IOException ex) {
                Logger.getLogger(ListeningThread.class.getName()).log(Level.SEVERE, null, ex);
            }
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
                        connection.disconnect();
                        break;
                    }
                }
                switch (step) {
                    case 0: {
                        if (data instanceof String) {
                            String msg = (String) data;
                            if (msg.equals("ERROR")) {
                                this.getControllerManager().getLogInController().logInFail();
                            }
                        } else{
                            HashMap employee = (HashMap) data;
                            this.getControllerManager().getLogInController().logInSuccess(employee);
                        }
                    }
                    break;
                }

            } catch (IOException ex) {
                Logger.getLogger(ListeningThread.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ListeningThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.exit(0);
    }
}
