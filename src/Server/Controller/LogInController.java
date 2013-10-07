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
public class LogInController extends BaseController {

    public void logIn(Admin account) {
        if (this.getServiceManager().getAdminManagerService().authenticate(account)) {
            BaseController.getSession().setCurrentAdmin(account);
            this.getFormManager().logInSuccess();
        }
        else{
            this.getFormManager().logInFail();
        }
    }
}
