package edu.poo2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseMotionAdapter;

public class Customer {
    public JPanel cliente;
    private JTextField textclienteuser;
    private JButton logInButton;
    private JButton singUpButton;
    private JButton returnButton;
    private JPasswordField passwordField1;

    public Customer() {
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Login" );
                frame.setSize(800,800);
                frame.setContentPane(new Beginning().Inicio);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });

        singUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Login" );
                frame.setSize(800,800);
                frame.setContentPane(new Sing().crear);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);


            }
        });

        logInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = textclienteuser.getText();
                String contraseña = passwordField1.getText();
                int pos = Usuario.verificarLogin(usuario,contraseña);
                if(pos == -1){
                    JOptionPane.showMessageDialog(null,"Error verifique los datos.");
                }else{
                    JOptionPane.showMessageDialog(null,"Datos correctos :).");
                    JFrame frame = new JFrame("Login");
                    frame.setSize(800, 800);
                    frame.setContentPane(new CostumerLogin().pacl);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setVisible(true);
                }
            }
        });
    }
}
