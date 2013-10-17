/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Server.Service;

import Server.Connection.DBConnection;
import Server.Entity.Zone;
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
public class ZoneManagerService {
    
    private DBConnection dbConnection;

    public ZoneManagerService() {
        dbConnection = new DBConnection();
    }
    
    public Zone get(String pin_Code) {
        dbConnection.connect();
        Connection connection = dbConnection.getConnection();
        PreparedStatement stm;
        ResultSet rs;
        Zone zone = new Zone();
        try {
            String query = "SELECT * FROM Zone WHERE pin_Code = ?";
            stm = connection.prepareStatement(query);
            stm.setString(1, pin_Code);
            rs = stm.executeQuery();
            if(!rs.next()) {
                return null;
            }
            zone.setPin_Code(pin_Code);
            zone.setZone_Name(rs.getString(2));
        } catch (SQLException ex) {
            Logger.getLogger(ZoneManagerService.class.getName()).log(Level.SEVERE, null, ex);
        }
        dbConnection.disconnect();
        return zone;
    }
    
    public ArrayList<Zone> getAll(){
        dbConnection.connect();
        Connection connection  = dbConnection.getConnection();
        PreparedStatement stm;
        ResultSet rs;
        ArrayList<Zone> zones = new ArrayList();
        try {
            String query = "SELECT * FROM Zone";
            stm = connection.prepareStatement(query);
            rs = stm.executeQuery();
            while(rs.next()) {
                Zone zone = new Zone();
                zone.setPin_Code(rs.getString(1));
                zone.setZone_Name(rs.getString(2));
                zones.add(zone);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ZoneManagerService.class.getName()).log(Level.SEVERE, null, ex);
        }
        dbConnection.disconnect();
        return zones;
    }
    
    public boolean save(Zone zone){
        dbConnection.connect();
        Connection connection = dbConnection.getConnection();
        PreparedStatement stm;
        int result = 0;
        try {
            String updateQuery = "UPDATE Zone SET zone_Name = ? WHERE pin_Code = ? ";
            stm = connection.prepareStatement(updateQuery);
            stm.setString(1, zone.getZone_Name());
            stm.setString(2, zone.getPin_Code());            
            result = stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AdminManagerService.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(result == 0){
            return false;
        }
        return true;
    }
    
    public boolean insert(Zone zone){
        dbConnection.connect();
        Connection connection = dbConnection.getConnection();
        PreparedStatement stm;
        int result = 0;
        try {
            String insertQuery = "INSERT INTO Zone VALUES(?,?)";
            stm = connection.prepareStatement(insertQuery);
            stm.setString(1, zone.getPin_Code());
            stm.setString(2, zone.getZone_Name());
            result = stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AdminManagerService.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(result == 0){
            return false;
        }
        return true;
    }
    
    public boolean delete(String pin_Code){
        dbConnection.connect();
        Connection connection = dbConnection.getConnection();
        PreparedStatement stm;
        int result = 0;
        try {
            String deleteQuery = "DELETE FROM Zone WHERE pin_Code = ?";
            stm = connection.prepareStatement(deleteQuery);
            stm.setString(1, pin_Code);
            result = stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AdminManagerService.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(result == 0){
            return false;
        }
        return true;
    }
}
