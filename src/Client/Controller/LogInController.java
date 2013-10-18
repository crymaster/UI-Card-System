/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Client.Controller;

import java.util.HashMap;


/**
 *
 * @author Son
 */
public class LogInController extends BaseController{
    //Send close connection signal to server
    public void close(){
        this.getServiceManager().getServerCommunicationService().send("CLOSE");
    }
    
    //Send log in request to server
    public void requestLogIn(HashMap account) {
        this.getServiceManager().getServerCommunicationService().send(account);
    }
    
    //Log in successfully
    public void logInSuccess(HashMap account){
        this.getFormManager().showMessageOnLogIn("Log in successfully", 1);
    }
    
    //Log in failure
    public void logInFail(){
        this.getFormManager().showMessageOnLogIn("Username or Password is not correct", 0);
    }
}
