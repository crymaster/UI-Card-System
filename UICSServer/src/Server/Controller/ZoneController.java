/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Server.Controller;

import Server.Entity.Zone;

/**
 *
 * @author QUANGHUY
 */
public class ZoneController extends BaseController{
    
    public void load() {
        //load all zone from database
        this.getFormManager().loadZones(this.getServiceManager().getZoneManagerService().getAll());
    }

    public void add(Zone zone) {
        //add a zone to database
        if (this.getServiceManager().getZoneManagerService().insert(zone)) {
            this.getFormManager().showMessageOnMainMenu("Add successfully !", 1);
        } else {
            this.getFormManager().showMessageOnMainMenu("PinCode has existed or saving error !", 0);
        }
    }
    
    public void update(Zone zone){
        //update zone in database
        if (this.getServiceManager().getZoneManagerService().save(zone)) {
            this.getFormManager().showMessageOnMainMenu("Update successfully !", 1);
        } else {
            this.getFormManager().showMessageOnMainMenu("An error has occured while saving !", 0);
        }
    }
    
    public void delete(String pin_Code){
        //delete a zone in database
        if (this.getServiceManager().getZoneManagerService().delete(pin_Code)){
            this.getFormManager().showMessageOnMainMenu("Delete completed !", 1);
        } else{
            this.getFormManager().showMessageOnMainMenu("An error has occured while deleting !", 0);
        }
    }
}
