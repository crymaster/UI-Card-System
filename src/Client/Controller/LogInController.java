/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Client.Controller;

/**
 *
 * @author Son
 */
public class LogInController extends BaseController{
    public void close(){
        this.getServiceManager().getServerCommunicationService().send("CLOSE");
    }
}
