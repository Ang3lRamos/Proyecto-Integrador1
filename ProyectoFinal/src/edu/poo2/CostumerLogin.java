package edu.poo2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CostumerLogin {
    private JButton listProductsButton;
    private JButton buyButton;
    public JPanel pacl;
    private JButton singOutButton;

    public CostumerLogin() {
        listProductsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Login" );
                frame.setSize(800,800);
                frame.setContentPane(new List().lista);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);


            }
        });
        buyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Login" );
                frame.setSize(800,800);
                frame.setContentPane(new Buy().buy);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);

            }
        });

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
    }
}
