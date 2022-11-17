/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TextWriter {
    
    
     /**
     * Method responsible for save a text file
     *
     * @param file   this string contains the filename
     * @param text   this string contains the text that will be saved
     */
    public static void execute(final String file, final String text) {
        final Path path = Paths.get("src/main/java/utils/" + file);
        
        try {
            Files.writeString(path, text,StandardCharsets.UTF_8);
            System.out.print("File saved successfully.");
        }
        catch (IOException ex) {
            System.out.print("Error saving file.");
        }
    }     
}
