/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Client.Controller;

import Client.Form.FormManager;
import Client.Service.ServiceManager;

/**
 *
 * @author Son
 */
public class BaseController {

    private ServiceManager serviceManager;
    private FormManager formManager;

    public ServiceManager getServiceManager() {
        return serviceManager;
    }

    public void setServiceManager(ServiceManager serviceManager) {
        this.serviceManager = serviceManager;
    }

    public FormManager getFormManager() {
        return formManager;
    }

    public void setFormManager(FormManager formManager) {
        this.formManager = formManager;
    }
}
