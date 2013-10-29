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

    public Admin get(String adminName) {
        dbConnection.connect();
        Connection connection = dbConnection.getConnection();
        PreparedStatement stm;
        ResultSet rs;
        Admin admin = new Admin();
        try {
            String query = "SELECT * FROM Admin WHERE adminName = ?";
            stm = connection.prepareStatement(query);
            stm.setString(1, adminName);
            rs = stm.executeQuery();
            if (!rs.next()) {
                return null;
            }
            admin.setAdminName(adminName);
            admin.setPassword(rs.getString(2));
            admin.setEmail(rs.getString(3));
        } catch (SQLException ex) {
            Logger.getLogger(AdminManagerService.class.getName()).log(Level.SEVERE, null, ex);
        }
        dbConnection.disconnect();
        return admin;
    }

    public ArrayList<Admin> getAll() {
        dbConnection.connect();
        Connection connection = dbConnection.getConnection();
        PreparedStatement stm;
        ResultSet rs;
        ArrayList<Admin> admins = new ArrayList();
        try {
            String query = "SELECT * FROM Admin";
            stm = connection.prepareStatement(query);
            rs = stm.executeQuery();
            while (rs.next()) {
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

    public boolean save(Admin admin) {
        dbConnection.connect();
        Connection connection = dbConnection.getConnection();
        PreparedStatement stm;
        int result = 0;
        try {
            String updateQuery = "UPDATE Admin SET password = ?, email = ? WHERE adminName = ? ";
            stm = connection.prepareStatement(updateQuery);
            stm.setString(1, admin.getPassword());
            stm.setString(2, admin.getEmail());
            stm.setString(3, admin.getAdminName());
            result = stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AdminManagerService.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (result == 0) {
            return false;
        }
        return true;
    }

    public boolean insert(Admin admin) {
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
        if (result == 0) {
            return false;
        }
        return true;
    }

    public boolean delete(String adminName) {
        dbConnection.connect();
        Connection connection = dbConnection.getConnection();
        PreparedStatement stm;
        int result = 0;
        try {
            String deleteQuery = "DELETE FROM Admin WHERE adminName = ?";
            stm = connection.prepareStatement(deleteQuery);
            stm.setString(1, adminName);
            result = stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AdminManagerService.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (result == 0) {
            return false;
        }
        return true;
    }

//    public boolean export(JTable tblCustList, String date, File file) {
//        //new blank workbook
//        XSSFWorkbook workbook = new XSSFWorkbook();
//        //Create a blank sheet
//        XSSFSheet sheet = workbook.createSheet("Customer Processed Report");
//
//        Map<String, Object[]> data = new TreeMap<String, Object[]>();
//
//        data.put("1", new Object[]{"ID", "FIRST NAME", "MIDDLE NAME", "LASTNAME", "UI Code", "Created Date"});
//        for (int i = 1; i <= tblCustList.getRowCount(); i++) {
//            data.put((i+1)+"", new Object[]{tblCustList.getValueAt(i - 1, 0), tblCustList.getValueAt(i - 1, 1), tblCustList.getValueAt(i - 1, 2), tblCustList.getValueAt(i - 1, 3), tblCustList.getValueAt(i - 1, 4), date});
//        }
//        //Iterate over data and write to sheet
//        Set<String> keyset = data.keySet();
//        int rownum = 0;
//        for (String key : keyset)
//        {
//            Row row = sheet.createRow(rownum++);
//            Object [] objArr = data.get(key);
//            int cellnum = 0;
//            for (Object obj : objArr)
//            {
//               Cell cell = row.createCell(cellnum++);
//               if(obj instanceof String)
//                    cell.setCellValue((String)obj);
//                else if(obj instanceof Integer)
//                    cell.setCellValue((Integer)obj);
//            }
//        }
//        try
//        {
//            //Write the workbook in file system
//            FileOutputStream out = new FileOutputStream(file);
//            workbook.write(out);
//            out.close();
//            return true;
//        } 
//        catch (Exception e) 
//        {
//            e.printStackTrace();
//            return false;
//        }
//    }

    public Admin authenticate(Admin account) {
        Admin admin = this.get(account.getAdminName());
        if (admin == null || !admin.getPassword().equals(account.getPassword())) {
            return null;
        }
        return admin;
    }
}
