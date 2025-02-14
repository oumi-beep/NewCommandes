package com.example.newcmmande.Controls;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private static String HOST="localhost";
    private static int PORT=3306;
    private static String DB_NAME="gestioncommande";
    private static String USER="root";
    private static String PASSWORD="oumayma2003";
    private static Connection connection;
    public DbConnection(){}
    public static Connection getConnect(){
        try {
            connection= DriverManager.getConnection(String.format("jdbc:mysql://%s:%s/%s",HOST,PORT,DB_NAME),USER,PASSWORD);
            return connection;
        } catch (SQLException e) {
             e.printStackTrace();
        }
        return connection;
    }
}
