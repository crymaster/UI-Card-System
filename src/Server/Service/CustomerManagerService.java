/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Server.Service;

import Server.Connection.DBConnection;
import Server.Entity.Customer;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author QUANGHUY
 */
public class CustomerManagerService {

    private DBConnection dbConnection;

    public CustomerManagerService() {
        dbConnection = new DBConnection();
    }

    public Customer get(int custID) {
        dbConnection.connect();
        Connection connection = dbConnection.getConnection();
        PreparedStatement stm;
        ResultSet rs;
        Customer cust = new Customer();
        try {
            String query = "SELECT * FROM Customer WHERE custID = ?";
            stm = connection.prepareStatement(query);
            stm.setInt(1, custID);
            rs = stm.executeQuery();
            if (!rs.next()) {
                return null;
            }
            cust.setCustID(custID);
            cust.setFirstName(rs.getString(2));
            cust.setMiddleName(rs.getString(3));
            cust.setLastName(rs.getString(4));
            cust.setDob(rs.getDate(5));
            cust.setGender(rs.getInt(6));
            cust.setContactDetail(rs.getString(7));
            cust.setEmail(rs.getString(8));
            cust.setAddress(rs.getString(9));
            cust.setEducation(rs.getString(10));
            cust.setOccupation(rs.getString(11));
            cust.setMarried(rs.getInt(12));
            cust.setAddressProof(rs.getInt(13));
            cust.setCitizenProof(rs.getString(14));
            cust.setHealth(rs.getString(15));
            cust.setCentreID(rs.getInt(16));
            cust.setUICode(rs.getString(17));
            cust.setThump(rs.getInt(18));
            cust.setFingerPrint(rs.getInt(19));
            cust.setRetinaScan(rs.getInt(20));
            cust.setStatus(rs.getInt(21));
            cust.setPersonalDetail(rs.getString(22));
            cust.setDateCreated(rs.getDate(23));
        } catch (SQLException ex) {
            Logger.getLogger(AdminManagerService.class.getName()).log(Level.SEVERE, null, ex);
        }
        dbConnection.disconnect();
        return cust;
    }

    public ArrayList<Customer> getAll() {
        dbConnection.connect();
        Connection connection = dbConnection.getConnection();
        PreparedStatement stm;
        ResultSet rs;
        ArrayList<Customer> custs = new ArrayList();
        try {
            String query = "SELECT Customer.*, Centre.centreName FROM Customer inner join Centre "
                    + "on Customer.centreID = Centre.centreID";
            stm = connection.prepareStatement(query);
            rs = stm.executeQuery();
            while (rs.next()) {
                Customer cust = new Customer();
                
                cust.setCustID(rs.getInt(1));
                cust.setFirstName(rs.getString(2));
                cust.setMiddleName(rs.getString(3));
                cust.setLastName(rs.getString(4));
                cust.setDob(rs.getDate(5));
                cust.setGender(rs.getInt(6));
                cust.setContactDetail(rs.getString(7));
                cust.setEmail(rs.getString(8));
                cust.setAddress(rs.getString(9));
                cust.setEducation(rs.getString(10));
                cust.setOccupation(rs.getString(11));
                cust.setMarried(rs.getInt(12));
                cust.setAddressProof(rs.getInt(13));
                cust.setCitizenProof(rs.getString(14));
                cust.setHealth(rs.getString(15));
                cust.setCentreID(rs.getInt(16));
                cust.setUICode(rs.getString(17));
                cust.setThump(rs.getInt(18));
                cust.setFingerPrint(rs.getInt(19));
                cust.setRetinaScan(rs.getInt(20));
                cust.setStatus(rs.getInt(21));
                cust.setPersonalDetail(rs.getString(22));
                cust.setDateCreated(rs.getDate(23));
                cust.setCentreName(rs.getString(24));
                
                custs.add(cust);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminManagerService.class.getName()).log(Level.SEVERE, null, ex);
        }
        dbConnection.disconnect();
        return custs;
    }

    public boolean save(Customer cust) {
        dbConnection.connect();
        Connection connection = dbConnection.getConnection();
        PreparedStatement stm;
        int result = 0;
        try {
            String updateQuery = "UPDATE Customer SET first_name = ?, middle_name = ?, "
                    + "last_name = ?, dob = ?, gender = ?, contact_detail = ?, email = ?, "
                    + "address = ?, education = ?, occupation = ?, married = ?, address_proof = ?, "
                    + "citizen_proof = ?, health = ?, centreID = ?, UICode = ?, thump = ?, "
                    + "fingerprint = ?, retina_scan = ?, status = ?, personal_detail =  ?, "
                    + "date_created = ? WHERE custID = ?";
            stm = connection.prepareStatement(updateQuery);
            stm.setString(1, cust.getFirstName());
            stm.setString(2, cust.getMiddleName());
            stm.setString(3, cust.getLastName());
            stm.setDate(4, (Date) cust.getDob());
            stm.setInt(5, cust.getGender());
            stm.setString(6, cust.getContactDetail());
            stm.setString(7, cust.getEmail());
            stm.setString(8, cust.getAddress());
            stm.setString(9, cust.getEducation());
            stm.setString(10, cust.getOccupation());
            stm.setInt(11, cust.getMarried());
            stm.setInt(12, cust.getAddressProof());
            stm.setString(13, cust.getCitizenProof());
            stm.setString(14, cust.getHealth());
            stm.setInt(15, cust.getCentreID());
            stm.setString(16, cust.getUICode());
            stm.setInt(17, cust.getThump());
            stm.setInt(18, cust.getFingerPrint());
            stm.setInt(19, cust.getRetinaScan());
            stm.setInt(20, cust.getStatus());
            stm.setString(21, cust.getPersonalDetail());
            stm.setDate(22, (Date) cust.getDateCreated());
            stm.setInt(23, cust.getCustID());
            result = stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AdminManagerService.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (result == 0) {
            return false;
        }
        return true;
    }

    public boolean insert(Customer cust) {
        dbConnection.connect();
        Connection connection = dbConnection.getConnection();
        PreparedStatement stm;
        int result = 0;
        try {
            String insertQuery = "INSERT INTO Customer VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            stm = connection.prepareStatement(insertQuery);
            stm.setInt(1, cust.getCustID());
            stm.setString(2, cust.getFirstName());
            stm.setString(3, cust.getMiddleName());
            stm.setString(4, cust.getLastName());
            stm.setDate(5, (Date) cust.getDob());
            stm.setInt(6, cust.getGender());
            stm.setString(7, cust.getContactDetail());
            stm.setString(8, cust.getEmail());
            stm.setString(9, cust.getAddress());
            stm.setString(10, cust.getEducation());
            stm.setString(11, cust.getOccupation());
            stm.setInt(12, cust.getMarried());
            stm.setInt(13, cust.getAddressProof());
            stm.setString(14, cust.getCitizenProof());
            stm.setString(15, cust.getHealth());
            stm.setInt(16, cust.getCentreID());
            stm.setString(17, cust.getUICode());
            stm.setInt(18, cust.getThump());
            stm.setInt(19, cust.getFingerPrint());
            stm.setInt(20, cust.getRetinaScan());
            stm.setInt(21, cust.getStatus());
            stm.setString(22, cust.getPersonalDetail());
            stm.setDate(23, (Date) cust.getDateCreated());
            result = stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AdminManagerService.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (result == 0) {
            return false;
        }
        return true;
    }

    public boolean delete(int custID) {
        dbConnection.connect();
        Connection connection = dbConnection.getConnection();
        PreparedStatement stm;
        int result = 0;
        try {
            String deleteQuery = "DELETE FROM Customer WHERE custID = ?";
            stm = connection.prepareStatement(deleteQuery);
            stm.setInt(1, custID);
            result = stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AdminManagerService.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (result == 0) {
            return false;
        }
        return true;
    }
    
    public ArrayList<Customer> search(String  firstName, String middleName, String lastName, String uicode, String date) {
        dbConnection.connect();
        Connection connection = dbConnection.getConnection();
        Statement stm;
        ResultSet rs;
        ArrayList<Customer> custs = new ArrayList<>();
        try {
            String selectQuery = "SELECT * FROM Customer WHERE 2>1 ";
            if(!(firstName == null) && !(firstName.isEmpty())) {
                selectQuery += " and first_name = '" + firstName + "'";
            }
            if(!(middleName == null) && !(middleName.isEmpty())) {
                selectQuery += " and middle_name = '" + middleName + "'";
            }
            if(!(lastName == null) && !(lastName.isEmpty())) {
                selectQuery += " and last_name = '" + lastName + "'";
            }
            if(!(uicode == null) && !(uicode.isEmpty())) {
                selectQuery += " and UICode = '" + uicode + "'";
            }
            
            stm = connection.createStatement();
            rs = stm.executeQuery(selectQuery);
            while(rs.next()) {
                Customer cust = new Customer();
                
                cust.setCustID(rs.getInt(1));
                cust.setFirstName(rs.getString(2));
                cust.setMiddleName(rs.getString(3));
                cust.setLastName(rs.getString(4));
                cust.setDob(rs.getDate(5));
                cust.setGender(rs.getInt(6));
                cust.setContactDetail(rs.getString(7));
                cust.setEmail(rs.getString(8));
                cust.setAddress(rs.getString(9));
                cust.setEducation(rs.getString(10));
                cust.setOccupation(rs.getString(11));
                cust.setMarried(rs.getInt(12));
                cust.setAddressProof(rs.getInt(13));
                cust.setCitizenProof(rs.getString(14));
                cust.setHealth(rs.getString(15));
                cust.setCentreID(rs.getInt(16));
                cust.setUICode(rs.getString(17));
                cust.setThump(rs.getInt(18));
                cust.setFingerPrint(rs.getInt(19));
                cust.setRetinaScan(rs.getInt(20));
                cust.setStatus(rs.getInt(21));
                cust.setPersonalDetail(rs.getString(22));
                cust.setDateCreated(rs.getDate(23));
                
                custs.add(cust);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminManagerService.class.getName()).log(Level.SEVERE, null, ex);
        }
        dbConnection.disconnect();
        return custs;
    }
}
