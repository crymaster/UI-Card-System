/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Client.Controller;

import Client.Connection.ListeningThread;
import java.util.HashMap;

/**
 *
 * @author Son
 */
public class LoggingController extends BaseController {
    //Send close connection signal to server

    public void connected(){
        this.getFormManager().logInConnected();
    }
    
    public void close() {
        this.getServiceManager().getServerCommunicationService().send("CLOSE");
        this.getServiceManager().getServerCommunicationService().close();
        System.exit(0);
    }

    //Send log in request to server
    public void requestLogIn(HashMap account) {
        this.getServiceManager().getServerCommunicationService().send(account);
    }

    //Respond to login result from server
    public void logIn(HashMap account) {
        if (account != null) {
            BaseController.getSession().setCurrentEmployee(account);
            this.getFormManager().showMessageOnLogIn("Log in successfully", 1);
            this.getFormManager().disposeLogIn();
            this.getFormManager().showMainMenu();
            this.getFormManager().updateProfile();
        } else{
            this.getFormManager().showMessageOnLogIn("Log in fail!\n 1.Username or password is not correct\n 2.Not the right centre", 0);
        }
    }
    
    public void logOut(){
        this.getServiceManager().getServerCommunicationService().send("LOGOUT");
        ListeningThread.setStep(ListeningThread.LOGGING_PHASE);
        this.getFormManager().disposeMainMenu();
        this.getFormManager().showLogIn();
    }
}
