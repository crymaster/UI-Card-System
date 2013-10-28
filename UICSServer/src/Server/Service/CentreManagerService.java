/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Server.Service;

import Server.Connection.DBConnection;
import Server.Entity.Centre;
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
public class CentreManagerService {
    
    private DBConnection dbConnection;
    
    public CentreManagerService() {
        dbConnection = new DBConnection();
    }
    
    public Centre get(String centreCode) {
        dbConnection.connect();
        Connection connection = dbConnection.getConnection();
        PreparedStatement stm;
        ResultSet rs;
        Centre centre = new Centre();
        try {
            String query = "SELECT Centre.*, Zone.zone_Name FROM Centre INNER JOIN Zone ON Centre.pin_Code = Zone.pin_Code WHERE centreCode = ?";
            stm = connection.prepareStatement(query);
            stm.setString(1, centreCode);
            rs = stm.executeQuery();
            if(!rs.next()) {
                return null;
            }
            centre.setCentreCode(rs.getString(1));
            centre.setPin_Code(rs.getString(2));
            centre.setCentreName(rs.getString(3));
            centre.setLocation(rs.getString(4));
            centre.setIp(rs.getString(5));
            centre.setZoneName(rs.getString(6));
        } catch (SQLException ex) {
            Logger.getLogger(CentreManagerService.class.getName()).log(Level.SEVERE, null, ex);
        }
        dbConnection.disconnect();
        return centre;
    }
    
    public Centre getByIp(String ip){
        dbConnection.connect();
        Connection connection = dbConnection.getConnection();
        PreparedStatement stm;
        ResultSet rs;
        Centre centre = new Centre();
        try {
            String query = "SELECT * FROM Centre WHERE ip = ?";
            stm = connection.prepareStatement(query);
            stm.setString(1, ip);
            rs = stm.executeQuery();
            if(!rs.next()) {
                return null;
            }
            centre.setCentreCode(rs.getString(1));
            centre.setPin_Code(rs.getString(2));
            centre.setCentreName(rs.getString(3));
            centre.setLocation(rs.getString(4));
            centre.setIp(rs.getString(5));
        } catch (SQLException ex) {
            Logger.getLogger(CentreManagerService.class.getName()).log(Level.SEVERE, null, ex);
        }
        dbConnection.disconnect();
        return centre;
    }
    
    public ArrayList<Centre> getByPinCode(String pinCode){
        dbConnection.connect();
        Connection connection = dbConnection.getConnection();
        PreparedStatement stm;
        ResultSet rs;
        ArrayList<Centre> centres = new ArrayList<>();
        try {
            String query = "SELECT Centre.*, Zone.zone_Name FROM Centre inner join Zone on Centre.pin_Code = Zone.pin_Code WHERE Centre.pin_Code = ?";
            stm = connection.prepareStatement(query);
            stm.setString(1, pinCode);
            rs = stm.executeQuery();
            while(rs.next()) {
                Centre centre = new Centre();
                centre.setCentreCode(rs.getString(1));
                centre.setPin_Code(rs.getString(2));
                centre.setCentreName(rs.getString(3));
                centre.setLocation(rs.getString(4));
                centre.setIp(rs.getString(5));
                centre.setZoneName(rs.getString(6));
                centres.add(centre);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CentreManagerService.class.getName()).log(Level.SEVERE, null, ex);
        }
        dbConnection.disconnect();
        return centres;
    }
    
    public ArrayList<Centre> getAll() {
        dbConnection.connect();
        Connection connection  = dbConnection.getConnection();
        PreparedStatement stm;
        ResultSet rs;
        ArrayList<Centre> centres = new ArrayList();
        try {
            String query = "SELECT Centre.*, Zone.zone_Name FROM Centre inner join Zone on Centre.pin_Code = Zone.pin_Code";
            stm = connection.prepareStatement(query);
            rs = stm.executeQuery();
            while(rs.next()) {
                Centre centre = new Centre();
                centre.setCentreCode(rs.getString(1));
                centre.setPin_Code(rs.getString(2));
                centre.setCentreName(rs.getString(3));
                centre.setLocation(rs.getString(4));
                centre.setIp(rs.getString(5));
                centre.setZoneName(rs.getString(6));
                centres.add(centre);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CentreManagerService.class.getName()).log(Level.SEVERE, null, ex);
        }
        dbConnection.disconnect();
        return centres;
    }
    
    public boolean save(Centre centre) {
        dbConnection.connect();
        Connection connection = dbConnection.getConnection();
        PreparedStatement stm;
        int result = 0;
        try {
            String updateQuery = "UPDATE Centre SET pin_Code = ?, centreName = ?,"
                    + " location = ?, ip = ? WHERE centreCode = ? ";
            stm = connection.prepareStatement(updateQuery);
            stm.setString(1, centre.getPin_Code());
            stm.setString(2, centre.getCentreName());
            stm.setString(3, centre.getLocation());
            stm.setString(4, centre.getIp());
            stm.setString(5, centre.getCentreCode());
            result = stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CentreManagerService.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(result == 0) {
            return false;
        }
        return true;
    }
    
    public boolean insert(Centre centre) {
        dbConnection.connect();
        Connection connection = dbConnection.getConnection();
        PreparedStatement stm;
        int result = 0;
        try {
            String insertQuery = "INSERT INTO Centre VALUES(?,?,?,?,?)";
            stm = connection.prepareStatement(insertQuery);
            stm.setString(1, centre.getCentreCode());
            stm.setString(2, centre.getPin_Code());
            stm.setString(3, centre.getCentreName());
            stm.setString(4, centre.getLocation());
            stm.setString(5, centre.getIp());
            result = stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CentreManagerService.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(result == 0) {
            return false;
        }
        return true;
    }
    
    public boolean delete(String centreCode) {
        dbConnection.connect();
        Connection connection = dbConnection.getConnection();
        PreparedStatement stm;
        int result = 0;
        try {
            String deleteQuery = "DELETE FROM Centre WHERE centreCode = ?";
            stm = connection.prepareStatement(deleteQuery);
            stm.setString(1, centreCode);
            result = stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CentreManagerService.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(result == 0) {
            return false;
        }
        return true;
    }
}
