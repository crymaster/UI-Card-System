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
public class LoggingController extends BaseController {

    public void logIn(Admin account) {
        //authenticate an account for logging in
        Admin admin = this.getServiceManager().getAdminManagerService().authenticate(account);
        if (admin!=null) {
            //set valid account to current sesstion
            BaseController.getSession().setCurrentAdmin(admin);
            //transform view
            this.getFormManager().showMessageOnLogIn("Log in successfully!", 1);
            this.getFormManager().disposeLogIn();
            this.getFormManager().showMainMenu();
        }
        else{
            this.getFormManager().showMessageOnLogIn("Login fail !\nAccount name or password is incorrect.", 0);
        }
    }
    
    public void logOut(){
        //clear session to log out
        BaseController.getSession().setCurrentAdmin(null);
        this.getFormManager().disposeMainMenu();
        this.getFormManager().showLogIn();
    }
}
