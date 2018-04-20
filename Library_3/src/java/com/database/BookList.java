package com.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import com.connectiondatabase.DatabaseConnection;
import com.enums.SearchType;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BookList {

    private ArrayList<Book> bookList = new ArrayList<>();

    public ArrayList<Book> getBooks(String query) {

        Statement st = null;
        ResultSet rs = null;
        Connection conn = null;
        Book book;
        try {
            conn = DatabaseConnection.getConnection();
            System.out.println(conn.isClosed());
            st = conn.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                book = new Book();
                book.setId(rs.getLong("id"));
                book.setName(rs.getString("name"));
                book.setPageCount(rs.getInt("page_count"));
                book.setIsbn(rs.getString("isbn"));
                book.setPublisherDate(rs.getDate("publish_year"));
                book.setPublisher(rs.getString("publisher"));
                book.setAuthor(rs.getString("author"));
                book.setGenre(rs.getString("genre"));
                book.setImage(rs.getBlob("image").getBytes(1, (int) rs.getBlob("image").length()));
                bookList.add(book);
            }
        } catch (SQLException exc) {
            Logger.getLogger(BookList.class.getName()).log(Level.SEVERE, null, exc);
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

        System.out.println(bookList);

        return bookList;
    }

    public ArrayList<Book> getBooksByGenre(long id) {

        return getBooks(
                "select b.id, b.name,b.page_count, b.isbn, b.publish_year,b.image, p.name as publisher, a.fio as author, g.name as genre from book b "
                + "join publisher p on b.publisher_id=p.id"
                + " join author a on a.id=b.author_id "
                + "join genre g on g.id=b.genre_id"
                + " where b.genre_id=" + id
        );

    }

    public ArrayList<Book> getBooksByLetter(String letter) {
        return getBooks("select b.id, b.name,b.page_count, b.isbn, b.publish_year,b.image, p.name as publisher, a.fio as author, g.name as genre from book b "
                + "join publisher p on b.publisher_id=p.id"
                + " join author a on a.id=b.author_id "
                + "join genre g on g.id=b.genre_id"
                + " where b.name like '" + letter + "%'"
        );
    }

    public ArrayList<Book> getBooksBySearch(String search, SearchType type) {
        String query = "select b.id, b.name,b.page_count, b.isbn, b.publish_year,b.image, p.name as publisher, a.fio as author, g.name as genre from book b "
                + "join publisher p on b.publisher_id=p.id"
                + " join author a on a.id=b.author_id "
                + "join genre g on g.id=b.genre_id"
                + " where ";
        
        if (type.equals(SearchType.AUTHOR)) {
            query += "a.fio like'%" + search +"%'";
        } else if (type.equals(SearchType.TITLE)) {
            query += "b.name like'%" + search +"%'";
        }

        return getBooks(query);
    }

    
    public ArrayList<Book> getAllBooks() {
        if (!bookList.isEmpty()) {
            return bookList;
        } else {
            return getBooks("select * from book order by name");
        }
    }

}
