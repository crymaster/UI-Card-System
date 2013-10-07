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
        if (this.getServiceManager().getAdminManagerService().save(admin)) {
            this.getFormManager().addAdminSuccess();
        } else {
            this.getFormManager().addAdminFail();
        }
    }
}
