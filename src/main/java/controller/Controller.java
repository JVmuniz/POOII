/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.Iterator;
import model.TextLine;
import model.TextLineDAO;
import utils.TextWriter;

public class Controller {
    
     /**
     * Method responsible for get a text from a group on database and save in a txt file
     *
     * @param username   this string contains the username to access the database
     * @param password   this string contains the password to access the database
     * @return String    this string contains the text found in the database
     */
    public static String getTextFromGroup(final String username, final String password) {
        final var textLineDAO = new TextLineDAO(username, password);
        final var textLines = textLineDAO.findAllTextLines();
        StringBuilder stringBuilder = new StringBuilder();
        
        Iterator<TextLine> iterator = textLines.iterator();
        while(iterator.hasNext()) {
            stringBuilder.append(iterator.next().getText());
            if(iterator.hasNext()) {
                stringBuilder.append('\n');
            }
        }  

        final var text = stringBuilder.toString();
        TextWriter.execute(textLines.get(0).getFile(), text);
        
        return text;
    }
}
