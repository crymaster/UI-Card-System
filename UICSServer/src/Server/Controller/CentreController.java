/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Server.Controller;

import Server.Entity.Centre;

/**
 *
 * @author QUANGHUY
 */
public class CentreController extends BaseController {
    public void load() {
        this.getFormManager().loadCentres(this.getServiceManager().getCentreManagerService().getAll());
    }

    public void add(Centre centre) {
        if (this.getServiceManager().getCentreManagerService().insert(centre)) {
            this.getFormManager().showMessageOnMainMenu("Add successfully !", 1);
        } else {
            this.getFormManager().showMessageOnMainMenu("Centre Code has existed or saving error !", 0);
        }
    }
    
    public void update(Centre centre){
        if (this.getServiceManager().getCentreManagerService().save(centre)) {
            this.getFormManager().showMessageOnMainMenu("Update successfully !", 1);
        } else {
            this.getFormManager().showMessageOnMainMenu("An error has occured while saving !", 0);
        }
    }
    
    public void delete(String centreCode){
        if (this.getServiceManager().getCentreManagerService().delete(centreCode)){
            this.getFormManager().showMessageOnMainMenu("Delete completed !", 1);
        } else{
            this.getFormManager().showMessageOnMainMenu("An error has occured while deleting !", 0);
        }
    }
}
