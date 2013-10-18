/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Server.Controller;

import Server.Entity.Employee;

/**
 *
 * @author QUANGHUY
 */
public class EmpController extends BaseController {

    public void load() {
        this.getFormManager().loadEmps(this.getServiceManager().getEmpManagerService().getAll());
    }

    public void add(Employee emp) {
        if (this.getServiceManager().getEmpManagerService().insert(emp)) {
            this.getFormManager().showMessageOnMainMenu("Add successfully !", 1);
        } else {
            this.getFormManager().showMessageOnMainMenu("Employee ID has existed or saving error !", 0);
        }
    }

    public void update(Employee emp) {
        if (this.getServiceManager().getEmpManagerService().save(emp)) {
            this.getFormManager().showMessageOnMainMenu("Update successfully !", 1);
        } else {
            this.getFormManager().showMessageOnMainMenu("An error has occured while saving !", 0);
        }
    }

    public void delete(int empID) {
        if (this.getServiceManager().getEmpManagerService().delete(empID)) {
            this.getFormManager().showMessageOnMainMenu("Delete completed !", 1);
        } else {
            this.getFormManager().showMessageOnMainMenu("An error has occured while deleting !", 0);
        }
    }
}