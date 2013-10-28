/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Server.Controller;

import Server.Form.FormManager;
import Server.Service.ServiceManager;
import Server.Util.Session;

/**
 *
 * @author Son
 */
public class BaseController {

    private ServiceManager serviceManager;
    private static Session session = new Session();
    private FormManager formManager;
            
    public ServiceManager getServiceManager() {
        return serviceManager;
    }

    public void setServiceManager(ServiceManager serviceManager) {
        this.serviceManager = serviceManager;
    }

    public static Session getSession() {
        return session;
    }

    public static void setSession(Session session) {
        BaseController.session = session;
    }

    public FormManager getFormManager() {
        return formManager;
    }

    public void setFormManager(FormManager formManager) {
        this.formManager = formManager;
    }
}
