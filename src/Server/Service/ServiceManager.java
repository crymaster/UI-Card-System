/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Server.Service;

/**
 *
 * @author Son
 */
public class ServiceManager {
    private AdminManagerService adminManagerService;

    public ServiceManager() {
        adminManagerService = new AdminManagerService();
    }
    
    public AdminManagerService getAdminManagerService() {
        return adminManagerService;
    }
    
}
