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
    
    public Centre get(int centreID) {
        dbConnection.connect();
        Connection connection = dbConnection.getConnection();
        PreparedStatement stm;
        ResultSet rs;
        Centre centre = new Centre();
        try {
            String query = "SELECT * FROM Centre WHERE centreID = ?";
            stm = connection.prepareStatement(query);
            stm.setInt(1, centreID);
            rs = stm.executeQuery();
            if(!rs.next()) {
                return null;
            }
            centre.setCentreID(centreID);
            centre.setPin_Code(rs.getString(2));
            centre.setCentreName(rs.getString(3));
            centre.setCentreCode(rs.getString(4));
            centre.setLocation(rs.getString(5));
            centre.setIp(rs.getString(6));
        } catch (SQLException ex) {
            Logger.getLogger(CentreManagerService.class.getName()).log(Level.SEVERE, null, ex);
        }
        dbConnection.disconnect();
        return centre;
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
                centre.setCentreID(rs.getInt(1));
                centre.setPin_Code(rs.getString(2));
                centre.setCentreName(rs.getString(3));
                centre.setCentreCode(rs.getString(4));
                centre.setLocation(rs.getString(5));
                centre.setIp(rs.getString(6));
                centre.setZoneName(rs.getString(7));
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
            String updateQuery = "UPDATE Centre SET centreID = ?, pin_Code = ?, centreName = ?,"
                    + " centreCode = ?, location = ?, ip = ? WHERE centreID = ? ";
            stm = connection.prepareStatement(updateQuery);
            stm.setInt(1, centre.getCentreID());
            stm.setString(2, centre.getPin_Code());
            stm.setString(3, centre.getCentreName());
            stm.setString(4, centre.getCentreCode());
            stm.setString(5, centre.getLocation());
            stm.setString(6, centre.getIp());
            stm.setInt(7, centre.getCentreID());
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
            String insertQuery = "INSERT INTO Centre VALUES(?,?,?,?,?,?)";
            stm = connection.prepareStatement(insertQuery);
            stm.setInt(1, centre.getCentreID());
            stm.setString(2, centre.getPin_Code());
            stm.setString(3, centre.getCentreName());
            stm.setString(4, centre.getCentreCode());
            stm.setString(5, centre.getLocation());
            stm.setString(6, centre.getIp());
            result = stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CentreManagerService.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(result == 0) {
            return false;
        }
        return true;
    }
    
    public boolean delete(int centreID) {
        dbConnection.connect();
        Connection connection = dbConnection.getConnection();
        PreparedStatement stm;
        int result = 0;
        try {
            String deleteQuery = "DELETE FROM Centre WHERE centreID = ?";
            stm = connection.prepareStatement(deleteQuery);
            stm.setInt(1, centreID);
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
