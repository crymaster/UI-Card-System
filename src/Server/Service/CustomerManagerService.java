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
            cust.setPassport(rs.getInt(13));
            cust.setVote(rs.getInt(14));
            cust.setDrivingLicense(rs.getInt(15));
            cust.setHealth(rs.getString(16));
            cust.setCentreCode(rs.getString(17));
            cust.setUICode(rs.getString(18));
            cust.setThump(rs.getInt(19));
            cust.setFingerPrint(rs.getInt(20));
            cust.setRetinaScan(rs.getInt(21));
            cust.setStatus(rs.getInt(22));
            cust.setPersonalDetail(rs.getString(23));
            cust.setDateCreated(rs.getDate(24));
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
                cust.setPassport(rs.getInt(13));
                cust.setVote(rs.getInt(14));
                cust.setDrivingLicense(rs.getInt(15));
                cust.setHealth(rs.getString(16));
                cust.setCentreCode(rs.getString(17));
                cust.setUICode(rs.getString(18));
                cust.setThump(rs.getInt(19));
                cust.setFingerPrint(rs.getInt(20));
                cust.setRetinaScan(rs.getInt(21));
                cust.setStatus(rs.getInt(22));
                cust.setPersonalDetail(rs.getString(23));
                cust.setDateCreated(rs.getDate(24));
                cust.setCentreName(rs.getString(25));

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
                    + "address = ?, education = ?, occupation = ?, married = ?, passport = ?, "
                    + "voter = ?, driving_license = ?,health = ?, centreCode = ?, UICode = ?, thump = ?, "
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
            stm.setInt(12, cust.getPassport());
            stm.setInt(13, cust.getVote());
            stm.setInt(14, cust.getDrivingLicense());
            stm.setString(15, cust.getHealth());
            stm.setString(16, cust.getCentreCode());
            stm.setString(17, cust.getUICode());
            stm.setInt(18, cust.getThump());
            stm.setInt(19, cust.getFingerPrint());
            stm.setInt(20, cust.getRetinaScan());
            stm.setInt(21, cust.getStatus());
            stm.setString(22, cust.getPersonalDetail());
            stm.setDate(23, (Date) cust.getDateCreated());
            stm.setInt(24, cust.getCustID());
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
            stm.setString(1, cust.getFirstName());
            stm.setString(2, cust.getMiddleName());
            stm.setString(3, cust.getLastName());
            stm.setDate(4, new Date(cust.getDob().getTime()));
            stm.setInt(5, cust.getGender());
            stm.setString(6, cust.getContactDetail());
            stm.setString(7, cust.getEmail());
            stm.setString(8, cust.getAddress());
            stm.setString(9, cust.getEducation());
            stm.setString(10, cust.getOccupation());
            stm.setInt(11, cust.getMarried());
            stm.setInt(12, cust.getPassport());
            stm.setInt(13, cust.getVote());
            stm.setInt(14, cust.getDrivingLicense());
            stm.setString(15, cust.getHealth());
            stm.setString(16, cust.getCentreCode());
            stm.setString(17, cust.getUICode());
            stm.setInt(18, cust.getThump());
            stm.setInt(19, cust.getFingerPrint());
            stm.setInt(20, cust.getRetinaScan());
            stm.setInt(21, cust.getStatus());
            stm.setString(22, cust.getPersonalDetail());
            stm.setDate(23, new Date(cust.getDateCreated().getTime()));
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

    public ArrayList<Customer> search(String firstName, String middleName, String lastName, String uicode, String date) {
        dbConnection.connect();
        Connection connection = dbConnection.getConnection();
        Statement stm;
        ResultSet rs;
        ArrayList<Customer> custs = new ArrayList<>();
        try {
            String selectQuery = "SELECT * FROM Customer WHERE 2>1 ";
            if (!(firstName == null) && !(firstName.isEmpty())) {
                selectQuery += " and first_name = '" + firstName + "'";
            }
            if (!(middleName == null) && !(middleName.isEmpty())) {
                selectQuery += " and middle_name = '" + middleName + "'";
            }
            if (!(lastName == null) && !(lastName.isEmpty())) {
                selectQuery += " and last_name = '" + lastName + "'";
            }
            if (!(uicode == null) && !(uicode.isEmpty())) {
                selectQuery += " and UICode = '" + uicode + "'";
            }

            stm = connection.createStatement();
            rs = stm.executeQuery(selectQuery);
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
                cust.setPassport(rs.getInt(13));
                cust.setVote(rs.getInt(14));
                cust.setDrivingLicense(rs.getInt(15));
                cust.setHealth(rs.getString(16));
                cust.setCentreCode(rs.getString(17));
                cust.setUICode(rs.getString(18));
                cust.setThump(rs.getInt(19));
                cust.setFingerPrint(rs.getInt(20));
                cust.setRetinaScan(rs.getInt(21));
                cust.setStatus(rs.getInt(22));
                cust.setPersonalDetail(rs.getString(23));
                cust.setDateCreated(rs.getDate(24));

                custs.add(cust);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminManagerService.class.getName()).log(Level.SEVERE, null, ex);
        }
        dbConnection.disconnect();
        return custs;
    }
}
