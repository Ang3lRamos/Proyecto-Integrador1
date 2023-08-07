package edu.poo2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Mananger {
    public JPanel admi;
    private JTextField textuser;
    private JLabel username;
    private JButton login;
    private JLabel mana;
    private JButton returnButton;
    private JPasswordField passwordField1;


    public Mananger() {
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
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String usuario = textuser.getText();
                String passwordd = passwordField1.getText();

                if(usuario.isEmpty() || passwordd.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Verifique los datos.");
                }else {
                    if (usuario.equals("cacastillo1121@gmail.com") && passwordd.equals("1121")) {
                        JOptionPane.showMessageDialog(null, "Bienvenido.");
                        JFrame frame = new JFrame("Login");
                        frame.setSize(800, 800);
                        frame.setContentPane(new Inicioman().Login);
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        frame.setVisible(true);
                    } else if (usuario.equals("yuneidy.salgados@unac.edu.co") && passwordd.equals("1231")) {
                        JOptionPane.showMessageDialog(null, "Bienvenido.");
                        JFrame frame = new JFrame("Login");
                        frame.setSize(800, 800);
                        frame.setContentPane(new Inicioman().Login);
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        frame.setVisible(true);

                    } else if (usuario.equals("jeanc.blancor@unac.edu.co") && passwordd.equals("2112")) {
                        JOptionPane.showMessageDialog(null, "Bienvenido.");
                        JFrame frame = new JFrame("Login");
                        frame.setSize(800, 800);
                        frame.setContentPane(new Inicioman().Login);
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        frame.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Verifique su usuario  contraseña");
                    }
                }

            }
        });
    }
}
