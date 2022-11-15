/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author gubec
 */
public abstract class DAO {
    
    public static Connection connection;
    public static Statement stm;
    private static ResultSet rs;
    //String driver = "com.mysql.jdbc.Driver";

    protected void connect(final String username, final String password) {
        try {
           // System.setProperty("jbdc:Drivers", driver);
            connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/SI400", "root", password);
            System.out.println("Connected successfully");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    protected static ResultSet executeSql(final String sql) {
        try {
            stm = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stm.executeQuery(sql);
            return rs;
        } catch (SQLException ex) {
            System.out.println("Error executing sql" + ex);
        }
        return rs;
    }

    public void closeConnection() {
        try {
            connection.close();
            System.out.println("Desconnected successfully!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }    
}
