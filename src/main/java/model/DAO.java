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

public abstract class DAO {
    
    private static Connection connection;
    private static Statement stm;
    private static ResultSet rs;

     /**
     * Method responsible for connect on database
     *
     * @param username   this string contains the username to access the database
     * @param password   this string contains the password to access the database
     */
    protected void connect(final String username, final String password) {
        try {
            connection = DriverManager.getConnection("jdbc:mariadb://143.106.243.64:3306/SI400", username, password);
            System.out.println("Connected successfully");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

     /**
     * Method responsible for execute a SQL query on database
     *
     * @param sql           this string contains the sql query that will be executed
     * @return ResultSet    this ResultSet contains the result found on database
     */
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

     /**
     * Method responsible for disconnect to database
     */
    protected static void closeConnection() {
        try {
            connection.close();
            System.out.println("Desconnected successfully!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }    
}
