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
public class MainController extends BaseController{
    public void send(HashMap customer){
        customer.put("message", "ENTRY");
        this.getServiceManager().getServerCommunicationService().send(customer);
    }
    
    public void entrySuccess(HashMap data){
        this.getFormManager().toUIProcess(data);
    }
    
    public void entryFail(){
        this.getFormManager().showMessageOnMainMenu("An error has occured on server. Please try again", 0);
    }
}
