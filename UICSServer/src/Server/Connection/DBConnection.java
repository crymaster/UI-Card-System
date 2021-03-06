/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Server.Connection;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Son
 */
public class DBConnection {

    private Connection connection;
    private Properties prop;

    public DBConnection() {
        try {
            //load Connection.properties file into Properties object
            prop = new Properties();
            prop.load(new FileReader("./config/Connection.properties"));
        } catch (FileNotFoundException ex) {
            
        } catch (IOException ex) {
        }
    }

    public void connect() {
        try {
            //connect to database with the config from Properties object
            if (connection == null || connection.isClosed()) {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                connection = DriverManager.getConnection("jdbc:sqlserver://localhost:" + prop.getProperty("databasePort", "1433"), this.prop);
            }
        } catch (ClassNotFoundException ex) {
        } catch (SQLException ex) {
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void disconnect() {
        //close connection
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException ex) {
            }
        }
    }
}
