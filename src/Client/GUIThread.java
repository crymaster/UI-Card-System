/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

/**
 *
 * @author Son
 */
public class GUIThread implements Runnable{
    private SignIn signIn;

    public void setSignIn(SignIn signIn) {
        this.signIn = signIn;
    }
    
    public void run(){
        this.signIn.setVisible(true);
    }
}
