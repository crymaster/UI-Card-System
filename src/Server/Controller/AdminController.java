/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Server.Controller;

import Server.Entity.Admin;
/**
 *
 * @author Son
 */
public class AdminController extends BaseController {

    public void load() {
        this.getFormManager().loadAdmins(this.getServiceManager().getAdminManagerService().getAll());
    }

    public void add(Admin admin) {
        if (this.getServiceManager().getAdminManagerService().insert(admin)) {
            this.getFormManager().showMessageOnMainMenu("Add successfully !", 1);
        } else {
            this.getFormManager().showMessageOnMainMenu("Admin name has existed or saving error !", 0);
        }
    }
    
    public void update(Admin admin){
        if (this.getServiceManager().getAdminManagerService().save(admin)) {
            this.getFormManager().showMessageOnMainMenu("Update successfully !", 1);
        } else {
            this.getFormManager().showMessageOnMainMenu("An error has occured while saving !", 0);
        }
    }
    
    public void delete(String adminName){
        if (this.getServiceManager().getAdminManagerService().delete(adminName)){
            this.getFormManager().showMessageOnMainMenu("Delete completed !", 1);
        } else{
            this.getFormManager().showMessageOnMainMenu("An error has occured while deleting !", 0);
        }
    }
}
