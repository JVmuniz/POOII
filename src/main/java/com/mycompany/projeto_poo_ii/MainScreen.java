/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.projeto_poo_ii;
import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author CIANDT\joao.muniz
 */
public class MainScreen {

    public static void main(String[] args) {
       //Creating the Frame
        JFrame frame = new JFrame("Projeto POO");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        //Creating the MenuBar and adding components
        JMenuBar mb = new JMenuBar();
        JMenu m1 = new JMenu("Arquivo");
        JMenu m2 = new JMenu("Ajuda");
        mb.add(m1);
        mb.add(m2);
        JMenuItem m11 = new JMenuItem("Autenticar");
        JMenuItem m12 = new JMenuItem("Sair");
        m1.add(m11);
        m1.add(m12);
        
        JMenuItem m21 = new JMenuItem("Ajuda");
        JMenuItem m22 = new JMenuItem("Sobre");
        m2.add(m21);
        m2.add(m22);
        
        //Creating the panel for textArea
        JPanel middlePanel = new JPanel();
        middlePanel.setBorder(new TitledBorder(new EtchedBorder(), ""));
        JTextArea display = new JTextArea(25, 75);
        display.setEditable(false); // set textArea non-editable
        JScrollPane scroll = new JScrollPane(display);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        middlePanel.add(scroll);
        
        
        
        //Creating the panel at bottom and adding components
        JPanel panel = new JPanel(); // the panel is not visible in output
        JLabel label = new JLabel("Status da Conexão: ");
        panel.add(label); // Components Added using Flow Layout
        

        //Adding Components to the frame.
        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.getContentPane().add(BorderLayout.NORTH, mb);
        frame.getContentPane().add(BorderLayout.CENTER, middlePanel);
        frame.setVisible(true);
    }
}
