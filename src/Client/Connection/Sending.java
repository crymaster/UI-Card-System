/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Client.Connection;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Son
 */
public class Sending {

    ObjectOutputStream output;

    public ObjectOutputStream getOutput() {
        return output;
    }

    public void setOutput(ObjectOutputStream output) {
        this.output = output;
    }

    public void send(Object data) {
        if (output != null) {
            try {
                output.writeObject(data);
            } catch (IOException ex) {
                return;
            }
        }
    }

    public void close() {
        if (output != null) {
            try {
                output.close();
            } catch (IOException ex) {
                return;
            }
        }
    }
}
