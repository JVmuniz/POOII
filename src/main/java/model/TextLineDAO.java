/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TextLineDAO extends DAO {
    
     /**
     * Constructor responsible for get an instance connected in the database
     *
     * @param username   this string contains the username to access the database
     * @param password   this string contains the password to access the database
     */
    public TextLineDAO(final String username, final String password) {
        connect(username, password);
    }
    
     /**
     * Method responsible for get the text group on database
     *
     * @return List     this list contains all the lines found in the database
     */
    public List<TextLine> findAllTextLines() {
        final var lines = new ArrayList();
        final var rs = executeSql("SELECT * FROM Fragmentos WHERE groupId = 6 ORDER BY line");
        try {
            while(rs.next()) {
                lines.add(buildTextLine(rs));
            }
        } catch(final SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        finally {
            closeConnection();
        }
        return lines;
    }
    
    private TextLine buildTextLine(final ResultSet rs) {
        try {
            final var textLine = new TextLine(rs.getInt("groupId"),
                    rs.getString("file"), rs.getInt("line"), rs.getString("text"));
            return textLine;
        } catch (final SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return null;
    }
}
