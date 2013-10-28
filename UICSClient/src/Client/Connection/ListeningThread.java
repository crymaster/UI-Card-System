/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Client.Connection;

import Client.Controller.ControllerManager;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.SocketException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Son
 */
public class ListeningThread implements Runnable {
    public static final int LOGGING_PHASE = 0;
    public static final int ENTRY_PHASE = 1;
    public static final int UI_PHASE = 2;
    private ObjectInputStream input;
    private ServerConnection connection;
    private ControllerManager controllerManager;
    private static int step;

    public ListeningThread() {
        step = LOGGING_PHASE;
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

    public static void setStep(int step) {
        ListeningThread.step = step;
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
        while (!ServerConnection.closed) {
            try {
                Object data = input.readObject();
                switch (step) {
                    case 0: {
                        if (data instanceof String) {
                            String msg = (String) data;
                            if (msg.equals("ERROR")) {
                                this.getControllerManager().getLogInController().logIn(null);
                            }
                        } else{
                            HashMap employee = (HashMap) data;
                            this.getControllerManager().getLogInController().logIn(employee);
                            step = ENTRY_PHASE;
                        }
                        break;
                    }
                    case 1: {
                        HashMap dataPackage = (HashMap)data;
                        String msg = (String)dataPackage.get("message");
                        if(msg.equals("ENTRYSUCCESS")){
                            controllerManager.getMainController().entrySuccess(dataPackage);
                            step = UI_PHASE;
                        } else if (msg.equals("ENTRYFAIL")) {
                            controllerManager.getMainController().entryFail();
                        } else if (msg.equals("PROFILESUCCESS")){
                            controllerManager.getMainController().profileSuccess(dataPackage);
                        } else if (msg.equals("PROFILEFAIL")){
                            controllerManager.getMainController().profileFail();
                        }
                        break;
                    }
                    case 2: {
                        String msg = (String) data;
                        if(msg.equals("UISUCCESS")){
                            controllerManager.getMainController().uiSuccess();
                            step = ENTRY_PHASE;
                        } else if (msg.equals("UIFAIL")){
                            controllerManager.getMainController().uiFail();
                        }
                        break;
                    }
                }
            }catch (    IOException | ClassNotFoundException ex) {
                break;
            }
        }
    }
}
