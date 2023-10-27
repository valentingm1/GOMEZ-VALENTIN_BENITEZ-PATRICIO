package com.backend.parcial.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class H2Connection {

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
    }

    public static void main(String[] args) {
        Connection connection = null;

        try{
            connection = H2Connection.getConnection();
            if(connection == null){
                System.out.println("No anda");
            } else {
                System.out.println("Anda");
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
