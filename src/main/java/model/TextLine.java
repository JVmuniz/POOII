/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public final class TextLine {
    
    private final int groupId;
    private final String file;
    private final int line;
    private final String text;

    public TextLine(final int groupId, final String file, final int line, final String text) {
        this.groupId = groupId;
        this.file = file;
        this.line = line;
        this.text = text;
    }
    
    public int getGroupId() {
        return groupId;
    }

    public String getFile() {
        return file;
    }

    public int getLine() {
        return line;
    }

    public String getText() {
        return text;
    }
}
