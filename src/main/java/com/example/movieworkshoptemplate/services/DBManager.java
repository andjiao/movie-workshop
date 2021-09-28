package com.example.movieworkshoptemplate.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBManager {
    static Connection connection = null;
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
    Class.forName("com.mysql.jdbc.Driver");
        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306", "Christian", "baldur03");
            String setDB = "CREATE DATABASE IF NOT EXISTS movies";
            PreparedStatement ps = connection.prepareStatement(setDB);
            ps.executeQuery();
        }
        catch (SQLException err) {
            System.out.println(err);
        }
        return connection;
    }
}
