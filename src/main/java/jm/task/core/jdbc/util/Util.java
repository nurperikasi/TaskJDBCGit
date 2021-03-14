package jm.task.core.jdbc.util;

import org.hibernate.sql.Select;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Util {
    // реализуйте настройку соеденения с БД
    private static final String URL = "jdbc:mysql://localhost:3306/mydbtest?autoReconnect=true&useSSL=false";

     private static final String USER = "root1";
     private static final String PASSWORD = "root1";

     public static Connection getConnection() throws ClassNotFoundException, SQLException {
         Connection connection = null;
         try {
             connection = DriverManager.getConnection(URL, USER, PASSWORD);

             return connection;
         } catch (SQLException throwables) {
             System.out.println("connection failed ");;
         }
         return connection;
     }
}

