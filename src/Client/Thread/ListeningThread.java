/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Client.Thread;

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
                input = null;
            } catch (IOException ex) {
                Logger.getLogger(ListeningThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    @Override
    public void run() {
        while(true){
            try {
                if(input == null)   break;
                input.readObject();
                
            } catch (IOException ex) {
                //Logger.getLogger(ListeningThread.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ListeningThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
