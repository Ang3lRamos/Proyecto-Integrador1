package edu.poo2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Beginning {
    public JPanel Inicio;
    private JButton buttoncliente;
    private JButton buttAdmi;

    public Beginning() {
        buttAdmi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame3 = new JFrame("Login");
                frame3.setSize(800,800);
                frame3.setContentPane(new Mananger().admi);
                frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame3.setVisible(true);

            }
        });
        buttoncliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame3 = new JFrame("Login");
                frame3.setSize(800,800);
                frame3.setContentPane(new Customer().cliente);
                frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame3.setVisible(true);

            }
        });
    }
}
