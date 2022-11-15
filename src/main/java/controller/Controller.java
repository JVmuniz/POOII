/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.Iterator;
import model.TextLine;
import model.TextLineDAO;
import utils.TextWriter;

/**
 *
 * @author gubec
 */
public class Controller {
    
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
