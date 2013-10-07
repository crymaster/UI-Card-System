/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Server.Service;

import Server.Connection.DBConnection;
import Server.Entity.Admin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Son
 */
public class AdminManagerService {

    private DBConnection dbConnection;

    public AdminManagerService() {
        dbConnection = new DBConnection();
    }

    public Admin getAdminByName(String adminName) {
        dbConnection.connect();
        Connection connection = dbConnection.getConnection();
        PreparedStatement stm;
        ResultSet rs;
        Admin admin = new Admin();
        try {
            String query = "SELECT adminName, password FROM Admin WHERE adminName = ?";
            stm = connection.prepareStatement(query);
            stm.setString(1, adminName);
            rs = stm.executeQuery();
            if (!rs.next()) {
                return null;
            }
            admin.setAdminName(adminName);
            admin.setPassword(rs.getString(2));
        } catch (SQLException ex) {
            Logger.getLogger(AdminManagerService.class.getName()).log(Level.SEVERE, null, ex);
        }
        dbConnection.disconnect();
        return admin;
    }

    public ArrayList<Admin> getAll(){
        dbConnection.connect();
        Connection connection  = dbConnection.getConnection();
        PreparedStatement stm;
        ResultSet rs;
        ArrayList<Admin> admins = new ArrayList();
        try {
            String query = "SELECT * FROM Admin";
            stm = connection.prepareStatement(query);
            rs = stm.executeQuery();
            while(rs.next()){
                Admin admin = new Admin();
                admin.setAdminName(rs.getString(1));
                admin.setPassword(rs.getString(2));
                admin.setEmail(rs.getString(3));
                admins.add(admin);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminManagerService.class.getName()).log(Level.SEVERE, null, ex);
        }
        dbConnection.disconnect();
        return admins;
    }
    
    public boolean save(Admin admin){
        dbConnection.connect();
        Connection connection = dbConnection.getConnection();
        PreparedStatement stm;
        int result = 0;
        try {
            String insertQuery = "INSERT INTO Admin VALUES(?,?,?)";
            stm = connection.prepareStatement(insertQuery);
            stm.setString(1, admin.getAdminName());
            stm.setString(2, admin.getPassword());
            stm.setString(3, admin.getEmail());
            result = stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AdminManagerService.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(result == 0){
            return false;
        }
        return true;
    }
    
    public boolean authenticate(Admin account) {
        Admin admin = this.getAdminByName(account.getAdminName());
        if(admin == null || !admin.getPassword().equals(account.getPassword())){
            return false;
        }
        return true;
    }
}