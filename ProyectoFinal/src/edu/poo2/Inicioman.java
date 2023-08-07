package edu.poo2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Inicioman {
    public JPanel Login;
    private JButton Products;
    private JLabel Welcome;
    private JButton singOutButton;


    public Inicioman() {
        singOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Login");
                frame.setSize(800, 800);
                frame.setContentPane(new Beginning().Inicio);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });

        Products.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame framePrin = new JFrame("Login");
                framePrin.setSize(800, 800);
                framePrin.setContentPane(new Products().productos);
                framePrin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                framePrin.setVisible(true);
            }
        });
    }
}
