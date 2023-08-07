package edu.poo2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Sing {
    private JTextField textFieldName;
    private JTextField textFieldLats;
    private JTextField textFieldcorreo;
    private JPasswordField passwordField1;
    private JPasswordField confirmrdField2;
    private JButton createButton;
    public JPanel crear;


    public Sing() {
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = textFieldcorreo.getText();
                String contraseña = passwordField1.getText();
                String confirmarContraseña = confirmrdField2.getText();
                Usuario obj = new Usuario();
                if(Usuario.verificarUsuario(usuario)==-1){
                    obj.setNick(usuario);
                    obj.setcContraseña(contraseña);
                    obj.setcContraseña(confirmarContraseña);
                    ListaUsuario.agregar(obj);
                    JOptionPane.showMessageDialog(null,"Usuario registrado.");
                    JFrame frame = new JFrame("Login" );
                    frame.setSize(800,800);
                    frame.setContentPane(new Customer().cliente);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setVisible(true);
                }else {
                    JOptionPane.showMessageDialog(null, "Este usuario ya esta siendo usado.");
                }
            }
        });
    }
}
