package com.database;

import com.connectiondatabase.DatabaseConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;
import java.util.logging.Level;

public class Book {

    private String name;
    private String genre;
    private String publisher;
    private int pageCount;
    private String isbn;
    Date publisherDate;
    private long id;
    private String author;
    private byte[] image;
    private byte[] content;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setPublisherDate(Date publisherDate) {
        this.publisherDate = publisherDate;
    }

    public Date getPublisherDate() {
        return publisherDate;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public byte[] getImage() {
        return image;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public byte[] getContent() {
        return content;
    }

    public void fillPdfContent() {

        String query = "select content from book where id=" + this.getId();

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {

            conn = DatabaseConnection.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery(query);

            while (rs.next()) {
                this.setContent(rs.getBlob("content").getBytes(1, (int) rs.getBlob("content").length()));
            }

        } catch (SQLException exc) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, exc);
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException exc) {
                Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, exc);
            }
        }
    }

    @Override
    public String toString() {
        return "Book{" + "name=" + name + ", genreName=" + genre
                + ", publisher=" + publisher + ", pageCount=" + pageCount
                + ", isbn=" + isbn + ", publisherDate=" + publisherDate
                + ", id=" + id + ", author=" + author
                + '}';
    }

}
