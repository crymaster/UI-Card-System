/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Server.Entity;

import java.io.Serializable;
import java.util.HashMap;

/**
 *
 * @author QUANGHUY
 */
public class Employee implements Serializable{
    
    private int empID;
    private String empName;
    private String password;
    private String email;
    private String centreCode;
    private String centreName;

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCentreCode() {
        return centreCode;
    }

    public void setCentreCode(String centreCode) {
        this.centreCode = centreCode;
    }

    public String getCentreName() {
        return centreName;
    }

    public void setCentreName(String centreName) {
        this.centreName = centreName;
    }
    
    public HashMap toHashMap(){
        HashMap data = new HashMap();
        data.put("empID", this.empID);
        data.put("empName", this.empName);
        data.put("password", this.password);
        data.put("email", this.email);
        data.put("centreCode", this.centreCode);
        data.put("centreName", this.centreName);
        return data;
    }
}
