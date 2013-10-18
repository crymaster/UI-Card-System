/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Client.Form;

import javax.swing.JOptionPane;

/**
 *
 * @author Son
 */
public class FormManager implements Runnable {

    private LogIn logIn;

    public FormManager() {
        logIn = new LogIn();
    }

    public LogIn getLogIn() {
        return logIn;
    }

    public void setLogIn(LogIn logIn) {
        this.logIn = logIn;
    }
    
    public void showMessageOnLogIn(String message, int messageType){
        JOptionPane.showMessageDialog(this.logIn, message,"Message",messageType);
    }
    
    @Override
    public void run() {
        this.logIn.setVisible(true);
    }
}
