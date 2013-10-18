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
        Admin admin = this.getServiceManager().getAdminManagerService().authenticate(account);
        if (admin!=null) {
            BaseController.getSession().setCurrentAdmin(admin);
            this.getFormManager().showMessageOnLogIn("Log in successfully!", 1);
            this.getFormManager().disposeLogIn();
            this.getFormManager().showMainMenu();
        }
        else{
            this.getFormManager().showMessageOnLogIn("Login fail !\nAccount name or password is incorrect.", 0);
        }
    }
    
    public void logOut(){
        BaseController.getSession().setCurrentAdmin(null);
        this.getFormManager().disposeMainMenu();
        this.getFormManager().showLogIn();
    }
}
