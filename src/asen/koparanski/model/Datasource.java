package asen.koparanski.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Datasource {

    public static final String DB_NAME = "BookShop.db";

    public static final String CONNECTION_STRING = "jdbc:sqlite:D:\\workspace\\BookShop\\" + DB_NAME;

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
