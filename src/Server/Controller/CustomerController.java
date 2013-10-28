/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Server.Controller;

import Server.Entity.Customer;
import java.util.ArrayList;

/**
 *
 * @author QUANGHUY
 */
public class CustomerController extends BaseController {
    
    public void load() {
        this.getFormManager().loadCusts(this.getServiceManager().getCustManagerService().getAll());
    }

    public void add(Customer cust) {
        if (this.getServiceManager().getCustManagerService().insert(cust)) {
            this.getFormManager().showMessageOnMainMenu("Add successfully !", 1);
        } else {
            this.getFormManager().showMessageOnMainMenu("Customer ID has existed or saving error !", 0);
        }
    }
    
    public void update(Customer cust){
        if (this.getServiceManager().getCustManagerService().save(cust)) {
            this.getFormManager().showMessageOnMainMenu("Update successfully !", 1);
        } else {
            this.getFormManager().showMessageOnMainMenu("An error has occured while saving !", 0);
        }
    }
    
    public void delete(int custID){
        if (this.getServiceManager().getCustManagerService().delete(custID)){
            this.getFormManager().showMessageOnMainMenu("Delete completed !", 1);
        } else{
            this.getFormManager().showMessageOnMainMenu("An error has occured while deleting !", 0);
        }
    }
    
    public void search(String firstName, String middleName, String lastName, String uicode, String date, int status, String centreName) {
        this.getFormManager().loadCusts(this.getServiceManager().getCustManagerService().search(firstName, middleName, lastName, uicode, date, status, centreName));
    }
    
    public void updateStatus(ArrayList custIDs) {
        if (this.getServiceManager().getCustManagerService().updateStatus(custIDs)) {
            this.getFormManager().showMessageOnMainMenu("Done !", 1);
        } else {
            this.getFormManager().showMessageOnMainMenu("An error has occured !", 0);
        }
    }
}
