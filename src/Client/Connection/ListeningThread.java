/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Client.Connection;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Son
 */
public class ListeningThread implements Runnable{
    private ObjectInputStream input;
    private ServerConnection connection;

    public ServerConnection getConnection() {
        return connection;
    }

    public void setConnection(ServerConnection connection) {
        this.connection = connection;
    }
    
    public ObjectInputStream getInput() {
        return input;
    }

    public void setInput(ObjectInputStream input) {
        this.input = input;
    }

    public void close(){
        if(input!= null){
            try {
                input.close();
            } catch (IOException ex) {
                Logger.getLogger(ListeningThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    @Override
    public void run() {
        while(true){
            try {
                Object data = input.readObject();
                if(data instanceof String){
                    String msg = (String) data;
                    if(msg.equals("CLOSE")){
                       connection.disconnect();
                       break;
                    }
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
