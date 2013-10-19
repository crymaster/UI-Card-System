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
}
