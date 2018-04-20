package com.database;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import com.connectiondatabase.DatabaseConnection;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.ArrayList;
import java.util.Collections;

public class AuthorList {

    private DatabaseConnection dc;
    private Connection conn = null;
    private Statement st = null;
    private ResultSet rs = null;
    private ArrayList<String> authorList = null;

    public AuthorList() {
        authorList = new ArrayList<>();
        dc = new DatabaseConnection();
        conn = dc.getConnection();
    }

    public ArrayList<String> getAuthors() {

        try {
            if (conn != null) {
                st = conn.createStatement();
            } else {
                System.out.println("Connection is lost");
            }
            rs = st.executeQuery("select * from author");
            while (rs.next()) {
                authorList.add(rs.getString("fio"));
            }
        } catch (SQLException exc) {
            Logger.getLogger(AuthorList.class.getName()).log(Level.SEVERE, null, exc);
        } finally {
            try {
                if(conn != null)conn.close();
                if(st != null)st.close();
                if(rs != null)rs.close();
            } catch (SQLException exc) {
                Logger.getLogger(AuthorList.class.getName()).log(Level.SEVERE, null, exc);
            }
        }

        Collections.sort(authorList);
        return authorList;
    }

    public ArrayList<String> getAuthorsList() {

        if (!authorList.isEmpty()) {
            return authorList;
        } else {
            return getAuthors();
        }

    }
}
