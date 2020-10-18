package com.example.jmusicDemo.data_access;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionHelper {

    // Creation of a connection object
    private String URL;
    private static ConnectionHelper instanceObject;

    private ConnectionHelper() {
        URL = "jdbc:sqlite::resource:Chinook_Sqlite.sqlite";
    }

    public static Connection getConnection() throws SQLException {

        if (instanceObject == null) {
            instanceObject = new ConnectionHelper();
        }
        try {
            return DriverManager.getConnection(instanceObject.URL);
        } catch (SQLException SqlEx) {
            System.out.println("Could not connect to database. Exception thrown!");
            throw SqlEx;
        }
    }

    public static void close(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
