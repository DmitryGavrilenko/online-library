package com.connectiondatabase;

import java.sql.SQLException;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import javax.naming.NamingException;

public class DatabaseConnection {

    private static Connection conn = null;
    private static InitialContext ic = null;
    private static DataSource ds = null;

    public DatabaseConnection() {

        try {
            ic = new InitialContext();
            ds = (DataSource) ic.lookup("java:comp/env/jdbc/Library");
            conn = ds.getConnection();
        } catch (SQLException exc) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, exc);
        } catch (NamingException exc) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, exc);
        }

    }

    public static Connection getConnection() {
        return conn;
    }

    public void close() {
        try {

            if (ic != null) {
                ic.close();
            }
            if (conn != null) {
                conn.close();
            }

        } catch (SQLException exc) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, exc);
        } catch (NamingException exc) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, exc);
        }
    }
}
