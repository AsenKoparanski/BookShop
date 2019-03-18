package main.koparanski.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: Asen Koparanski
 * Purpose: Handle database operations. Singleton class.
 * Date: 17.03.2019
 */

public class Datasource {

    public static final String DB_NAME = "BookShop.db";

    public static final String CONNECTION_STRING = "jdbc:sqlite:D:\\workspace\\BookShop\\" + DB_NAME;

    public static final String TABLE_BOOKS = "books";
    public static final String COLUMN_BOOK_ID = "id";
    public static final String COLUMN_BOOK_TITLE = "title";
    public static final String COLUMN_BOOK_YEAR = "year";
    public static final String COLUMN_BOOK_PRICE = "price";

    public static final int INDEX_BOOK_ID = 1;
    public static final int INDEX_BOOK_TITLE = 2;
    public static final int INDEX_BOOK_YEAR = 3;
    public static final int INDEX_BOOK_PRICE = 4;

    public static final String QUERY_BOOKS = "SELECT * FROM " + TABLE_BOOKS;

    private Connection conn;
    private static Datasource instance = new Datasource();

    private PreparedStatement queryBooks;

    /**
     * Private constructor, not instantiatable outside of class.
     */
    private Datasource() {

    }

    /**
     * Return the single instance of the class.
     * @return instance
     */
    public static Datasource getInstance() {
        return instance;
    }

    /**
     * Opens the SQL connection to the database.
     * Notifies if succeeded or failed.
     * @return boolean
     */
    public boolean open() {
        try {
            conn = DriverManager.getConnection(CONNECTION_STRING);
            queryBooks = conn.prepareStatement(QUERY_BOOKS);

            return true;
        } catch (SQLException e) {
            System.out.println("Couldn't connect to database: " + e.getMessage());
            return false;
        }
    }
    /**
     * Closes the SQL connection to the database.
     * Notifies if succeeded or failed.
     * @return boolean
     */
    public void close() {
        try {
            if (queryBooks != null) {
                queryBooks.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println("Couldn't close connection: " + e.getMessage());
        }
    }

    /**
     * Query the database for a list of all the books.
     * @return books
     */
    public List<Book> queryBooks() {

        List<Book> books = new ArrayList<>();

        try {
            ResultSet results = queryBooks.executeQuery();
            while (results.next()) {
                Book book = new Book();
                book.setId(results.getInt(INDEX_BOOK_ID));
                book.setTitle(results.getString(INDEX_BOOK_TITLE));
                book.setYear(results.getInt(INDEX_BOOK_YEAR));
                book.setPrice(results.getDouble(INDEX_BOOK_PRICE));
                books.add(book);
            }
            return books;
        } catch(SQLException e) {
            System.out.println("Couldn't retrieve books: " + e.getMessage());
            return null;
        }

    }

}
