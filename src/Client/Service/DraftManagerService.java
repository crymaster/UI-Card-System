/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Client.Service;

import Client.Connection.ClientDBConnection;
import Client.Entity.Draft;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Son
 */
public class DraftManagerService {

    private ClientDBConnection dbConnection;

    public DraftManagerService() {
        dbConnection = new ClientDBConnection();
    }

    public Draft get(int draftID) {
        dbConnection.connect();
        Connection connection = dbConnection.getConnection();
        PreparedStatement stm;
        ResultSet rs;
        Draft draft = new Draft();
        try {
            String query = "SELECT * FROM Draft WHERE draftID = ?";
            stm = connection.prepareStatement(query);
            stm.setInt(1, draftID);
            rs = stm.executeQuery();
            if (!rs.next()) {
                return null;
            }
            draft.setDraftId(draftID);
            draft.setFirstName(rs.getString(2));
            draft.setMiddleName(rs.getString(3));
            draft.setLastName(rs.getString(4));
            if (rs.getDate(5) != null) {
                draft.setDob(new Date(rs.getDate(5).getTime()));
            }
            draft.setGender(rs.getInt(6));
            draft.setContactDetail(rs.getString(7));
            draft.setEmail(rs.getString(8));
            draft.setAddress(rs.getString(9));
            draft.setEducation(rs.getString(10));
            draft.setOccupation(rs.getString(11));
            draft.setMarried(rs.getBoolean(12));
            draft.setPassport(rs.getBoolean(13));
            draft.setVoter(rs.getBoolean(14));
            draft.setDrivingLicense(rs.getBoolean(15));
            draft.setHealth(rs.getString(16));
        } catch (SQLException ex) {
            Logger.getLogger(DraftManagerService.class.getName()).log(Level.SEVERE, null, ex);
        }
        dbConnection.disconnect();
        return draft;
    }

    public ArrayList<Draft> getAll() {
        dbConnection.connect();
        Connection connection = dbConnection.getConnection();
        PreparedStatement stm;
        ResultSet rs;
        ArrayList<Draft> drafts = new ArrayList();
        try {
            String query = "SELECT * FROM Draft";
            stm = connection.prepareStatement(query);
            rs = stm.executeQuery();
            while (rs.next()) {
                Draft draft = new Draft();
                draft.setDraftId(rs.getInt(1));
                draft.setFirstName(rs.getString(2));
                draft.setMiddleName(rs.getString(3));
                draft.setLastName(rs.getString(4));
                if (rs.getDate(5) != null) {
                    draft.setDob(new Date(rs.getDate(5).getTime()));
                } else {
                }
                draft.setGender(rs.getInt(6));
                draft.setContactDetail(rs.getString(7));
                draft.setEmail(rs.getString(8));
                draft.setAddress(rs.getString(9));
                draft.setEducation(rs.getString(10));
                draft.setOccupation(rs.getString(11));
                draft.setMarried(rs.getBoolean(12));
                draft.setPassport(rs.getBoolean(13));
                draft.setVoter(rs.getBoolean(14));
                draft.setDrivingLicense(rs.getBoolean(15));
                draft.setHealth(rs.getString(16));
                drafts.add(draft);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DraftManagerService.class.getName()).log(Level.SEVERE, null, ex);
        }
        dbConnection.disconnect();
        return drafts;
    }

    public boolean insert(Draft draft) {
        dbConnection.connect();
        Connection connection = dbConnection.getConnection();
        PreparedStatement stm;
        int result = 0;
        try {
            String insertQuery = "INSERT INTO Draft VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            stm = connection.prepareStatement(insertQuery);
            stm.setString(1, draft.getFirstName());
            stm.setString(2, draft.getMiddleName());
            stm.setString(3, draft.getLastName());
            if (draft.getDob() != null) {
                stm.setDate(4, new java.sql.Date(draft.getDob().getTime()));
            } else {
                stm.setDate(4, null);
            }
            stm.setInt(5, draft.getGender());
            stm.setString(6, draft.getContactDetail());
            stm.setString(7, draft.getEmail());
            stm.setString(8, draft.getAddress());
            stm.setString(9, draft.getEducation());
            stm.setString(10, draft.getOccupation());
            stm.setBoolean(11, draft.isMarried());
            stm.setBoolean(12, draft.isPassport());
            stm.setBoolean(13, draft.isVoter());
            stm.setBoolean(14, draft.isDrivingLicense());
            stm.setString(15, draft.getHealth());
            result = stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DraftManagerService.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (result == 0) {
            return false;
        }
        return true;
    }

    public boolean save(Draft draft) {
        dbConnection.connect();
        Connection connection = dbConnection.getConnection();
        PreparedStatement stm;
        int result = 0;
        try {
            String updateQuery = "UPDATE Draft SET first_name=?, middle_name=?, last_name=?,"
                    + "dob=?, gender=?, contact_detail=?, email=?,"
                    + "address=?, education=?, occupation=?, married=?,"
                    + "passport=?, voter=?, driving_license=?, health=? WHERE draftID=?";
            stm = connection.prepareStatement(updateQuery);
            stm.setString(1, draft.getFirstName());
            stm.setString(2, draft.getMiddleName());
            stm.setString(3, draft.getLastName());
            if (draft.getDob() != null) {
                stm.setDate(4, new java.sql.Date(draft.getDob().getTime()));
            } else {
                stm.setDate(4, null);
            }
            stm.setInt(5, draft.getGender());
            stm.setString(6, draft.getContactDetail());
            stm.setString(7, draft.getEmail());
            stm.setString(8, draft.getAddress());
            stm.setString(9, draft.getEducation());
            stm.setString(10, draft.getOccupation());
            stm.setBoolean(11, draft.isMarried());
            stm.setBoolean(12, draft.isPassport());
            stm.setBoolean(13, draft.isVoter());
            stm.setBoolean(14, draft.isDrivingLicense());
            stm.setString(15, draft.getHealth());
            stm.setInt(16, draft.getDraftId());
            result = stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DraftManagerService.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (result == 0) {
            return false;
        }
        return true;
    }

    public boolean delete(int draftID) {
        dbConnection.connect();
        Connection connection = dbConnection.getConnection();
        PreparedStatement stm;
        int result = 0;
        try {
            String deleteQuery = "DELETE FROM Draft WHERE draftID = ?";
            stm = connection.prepareStatement(deleteQuery);
            stm.setInt(1, draftID);
            result = stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DraftManagerService.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (result == 0) {
            return false;
        }
        return true;
    }
}
