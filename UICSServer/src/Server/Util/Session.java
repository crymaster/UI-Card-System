/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Server.Util;

import Server.Entity.Admin;

/**
 *
 * @author Son
 */
public class Session {

    private Admin currentAdmin;

    public Admin getCurrentAdmin() {
        return currentAdmin;
    }

    public void setCurrentAdmin(Admin currentAdmin) {
        this.currentAdmin = currentAdmin;
    }
}
