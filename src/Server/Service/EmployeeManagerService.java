/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Server.Service;

import Server.Connection.DBConnection;
import Server.Entity.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author QUANGHUY
 */
public class EmployeeManagerService {
    private DBConnection dbConnection;
    
    public EmployeeManagerService() {
        dbConnection = new DBConnection();
    }
    
    public Employee get(int empID) {
        dbConnection.connect();
        Connection connection = dbConnection.getConnection();
        PreparedStatement stm;
        ResultSet rs;
        Employee emp = new Employee();
        try {
            String query = "SELECT * FROM Employee WHERE empID = ?";
            stm = connection.prepareStatement(query);
            stm.setInt(1, empID);
            rs = stm.executeQuery();
            if(!rs.next()) {
                return null;
            }
            emp.setEmpID(empID);
            emp.setEmpName(rs.getString(2));
            emp.setPassword(rs.getString(3));
            emp.setEmail(rs.getString(4));
            emp.setCentreCode(rs.getString(5));
        } catch (SQLException ex) {
            Logger.getLogger(CentreManagerService.class.getName()).log(Level.SEVERE, null, ex);
        }
        dbConnection.disconnect();
        return emp;
    }
    
    public Employee getByEmpName(String empName) {
        dbConnection.connect();
        Connection connection = dbConnection.getConnection();
        PreparedStatement stm;
        ResultSet rs;
        Employee emp = new Employee();
        try {
            String query = "SELECT * FROM Employee WHERE empName = ?";
            stm = connection.prepareStatement(query);
            stm.setString(1, empName);
            rs = stm.executeQuery();
            if(!rs.next()) {
                return null;
            }
            emp.setEmpID(rs.getInt(1));
            emp.setEmpName(rs.getString(2));
            emp.setPassword(rs.getString(3));
            emp.setEmail(rs.getString(4));
            emp.setCentreCode(rs.getString(5));
        } catch (SQLException ex) {
            Logger.getLogger(CentreManagerService.class.getName()).log(Level.SEVERE, null, ex);
        }
        dbConnection.disconnect();
        return emp;
    }
    
    public ArrayList<Employee> getAll() {
        dbConnection.connect();
        Connection connection  = dbConnection.getConnection();
        PreparedStatement stm;
        ResultSet rs;
        ArrayList<Employee> emps = new ArrayList();
        try {
            String query = "SELECT empID, empName, password, email, centreName FROM Employee inner join Centre "
                    + "on Employee.centreID = Centre.centreID";
            stm = connection.prepareStatement(query);
            rs = stm.executeQuery();
            while(rs.next()) {
                Employee emp = new Employee();
                emp.setEmpID(rs.getInt(1));
                emp.setEmpName(rs.getString(2));
                emp.setPassword(rs.getString(3));
                emp.setEmail(rs.getString(4));
                emp.setCentreName(rs.getString(5));
                emps.add(emp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CentreManagerService.class.getName()).log(Level.SEVERE, null, ex);
        }
        dbConnection.disconnect();
        return emps;
    }
    
    public boolean save(Employee emp) {
        dbConnection.connect();
        Connection connection = dbConnection.getConnection();
        PreparedStatement stm;
        int result = 0;
        try {
            String updateQuery = "UPDATE Employee SET empID = ?, empName = ?,"
                    + " password = ?, email = ?, centreID = ? WHERE empID = ? ";
            stm = connection.prepareStatement(updateQuery);
            stm.setInt(1, emp.getEmpID());
            stm.setString(2, emp.getEmpName());
            stm.setString(3, emp.getPassword());
            stm.setString(4, emp.getEmail());
            stm.setString(5, emp.getCentreCode());
            result = stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CentreManagerService.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(result == 0) {
            return false;
        }
        return true;
    }
    
    public boolean insert(Employee emp) {
        dbConnection.connect();
        Connection connection = dbConnection.getConnection();
        PreparedStatement stm;
        int result = 0;
        try {
            String insertQuery = "INSERT INTO Employee VALUES(?,?,?,?,?)";
            stm = connection.prepareStatement(insertQuery);
            stm.setInt(1, emp.getEmpID());
            stm.setString(2, emp.getEmpName());
            stm.setString(3, emp.getPassword());
            stm.setString(4, emp.getEmail());
            stm.setString(5, emp.getCentreCode());
            result = stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CentreManagerService.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(result == 0) {
            return false;
        }
        return true;
    }
    
    public boolean delete(int empID) {
        dbConnection.connect();
        Connection connection = dbConnection.getConnection();
        PreparedStatement stm;
        int result = 0;
        try {
            String deleteQuery = "DELETE FROM Employee WHERE empID = ?";
            stm = connection.prepareStatement(deleteQuery);
            stm.setInt(1, empID);
            result = stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CentreManagerService.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(result == 0) {
            return false;
        }
        return true;
    }
    
    public Employee authenticate(Employee account){
        Employee employee = this.getByEmpName(account.getEmpName());
        if(employee == null || !employee.getPassword().equals(account.getPassword())){
            return null;
        }
        return employee;
    }
}
