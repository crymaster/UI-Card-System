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
        //load all admin from database
        this.getFormManager().loadAdmins(this.getServiceManager().getAdminManagerService().getAll());
    }

    public void add(Admin admin) {
        //insert an admin to database
        if (this.getServiceManager().getAdminManagerService().insert(admin)) {
            this.getFormManager().showMessageOnMainMenu("Add successfully !", 1);
        } else {
            this.getFormManager().showMessageOnMainMenu("Admin name has existed or saving error !", 0);
        }
    }
    
    public void update(Admin admin){
        //update an admin in database
        if (this.getServiceManager().getAdminManagerService().save(admin)) {
            this.getFormManager().showMessageOnMainMenu("Update successfully !", 1);
        } else {
            this.getFormManager().showMessageOnMainMenu("An error has occured while saving !", 0);
        }
    }
    
    public void delete(String adminName){
        //delete an admin in database
        if (this.getServiceManager().getAdminManagerService().delete(adminName)){
            this.getFormManager().showMessageOnMainMenu("Delete completed !", 1);
        } else{
            this.getFormManager().showMessageOnMainMenu("An error has occured while deleting !", 0);
        }
    }
    
//    public void export(JTable tblCustList, String date, File file) {
//        if(this.getServiceManager().getAdminManagerService().export(tblCustList, date, file)){
//            this.getFormManager().showMessageOnMainMenu("Done !", 1);
//        } else{
//            this.getFormManager().showMessageOnMainMenu("An error has occured !", 0);
//        }
//    }
}
