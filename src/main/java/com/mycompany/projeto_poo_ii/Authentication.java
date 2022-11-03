/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projeto_poo_ii;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
    
/**
 *
 * @author CIANDT\joao.muniz
 */
public class Authentication implements ActionListener {
    private static JTextField username;
    private static JPasswordField password;
    
    public static void main(String args[]){
        JFrame frame = new JFrame("Autenticação");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        
        JLabel label = new JLabel("Usuário");
        label.setBounds(100, 8, 70, 20);
        panel.add(label);
        
        username = new JTextField();
        username.setBounds(100, 27, 193, 28);
        panel.add(username);
        
        JLabel password1 = new JLabel("Senha");
        password1.setBounds(100, 55, 70, 20);
        panel.add(password1);
        
        password = new JPasswordField();
        password.setBounds(100, 75, 193, 28);
        panel.add(password);
        
        JButton button = new JButton("Login");
        button.setBounds(100, 110, 90, 25);
        button.setForeground(Color.WHITE);
        button.setBackground(Color.BLACK);
        button.addActionListener((ActionListener) new Authentication());
        panel.add(button);
        
        frame.add(panel);
        frame.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String Username = username.getText();
        String Password1 = password.getText();

        if (Username.equals("si400_2022") && Password1.equals("si400_2022"))
                JOptionPane.showMessageDialog(null, "Login Successful");
        else
                JOptionPane.showMessageDialog(null, "Username or Password mismatch ");
    }
}
