package asen.koparanski.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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

    private Connection conn;
    private static Datasource instance = new Datasource();


    private Datasource() {

    }
    public static Datasource getInstance() {
        return instance;
    }

    public boolean open() {
        try {
            conn = DriverManager.getConnection(CONNECTION_STRING);
            return true;
        } catch (SQLException e) {
            System.out.println("Couldn't connect to database: " + e.getMessage());
            return false;
        }
    }
    public void close() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println("Couldn't close connection: " + e.getMessage());
        }
    }

}
