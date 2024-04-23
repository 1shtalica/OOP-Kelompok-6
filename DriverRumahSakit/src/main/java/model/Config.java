/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author adria
 */

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
public class Config {
    public static Connection mysqlcon;
    public static Connection DBConn() throws SQLException {
        String username = "root";
        String password = "";
        String url = "jdbc:mysql://127.0.0.1:3306/rhs_db";
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            mysqlcon = DriverManager.getConnection(url, username, password);
            return mysqlcon;
        } catch (SQLException ex) {
            // Handle any potential database errors.
            throw new SQLException("Database connection failed!", ex);
        }
    }
}
