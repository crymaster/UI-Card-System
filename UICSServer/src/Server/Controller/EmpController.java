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
        if (this.getServiceManager().getEmpManagerService().getByEmpName(emp.getEmpName()) == null) {
            if (this.getServiceManager().getEmpManagerService().insert(emp)) {
                this.getFormManager().showMessageOnMainMenu("Add successfully !", 1);
            } else {
                this.getFormManager().showMessageOnMainMenu("Saving error !", 0);
            }
        } else {
            this.getFormManager().showMessageOnMainMenu("Employee name has existed!", 0);
        }
    }

    public void update(Employee emp) {
        Employee result = this.getServiceManager().getEmpManagerService().getByEmpName(emp.getEmpName());
        
        if (result == null || result.getEmpID() == emp.getEmpID()) {
            if (this.getServiceManager().getEmpManagerService().save(emp)) {
                this.getFormManager().showMessageOnMainMenu("Update successfully !", 1);
            } else {
                this.getFormManager().showMessageOnMainMenu("An error has occured while saving !", 0);
            }
        } else {
            this.getFormManager().showMessageOnMainMenu("Employee name has existed!", 0);
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
