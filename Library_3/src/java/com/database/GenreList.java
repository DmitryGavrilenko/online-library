package com.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import com.connectiondatabase.DatabaseConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GenreList {

    private Connection conn;
    private DatabaseConnection dc;
    private ArrayList<Genre> genreList;
    private Statement st;
    private ResultSet rs;

    public GenreList() {
        genreList = new ArrayList<>();
        dc = new DatabaseConnection();
        conn = dc.getConnection();
    }

    public ArrayList<Genre> getGenres() {

        try {
            st = conn.createStatement();
            rs = st.executeQuery("select * from genre order by name");
            while (rs.next()) {
                Genre genre = new Genre();
                genre.setId(rs.getLong("id"));
                genre.setName(rs.getString("name"));
                genreList.add(genre);
            }
        } catch (SQLException exc) {
            Logger.getLogger(GenreList.class.getName()).log(Level.SEVERE, null, exc);
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException exc) {
                Logger.getLogger(AuthorList.class.getName()).log(Level.SEVERE, null, exc);
            }
        }
        
        return genreList;
    }

    public ArrayList<Genre> getGenreList() {
        if (!genreList.isEmpty()) {
            return genreList;
        } else {
            return getGenres();
        }
    }

}
