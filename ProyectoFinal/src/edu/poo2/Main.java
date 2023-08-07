package edu.poo2;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        JFrame framePrin = new JFrame("Login" );
        framePrin.setSize(800,800);
        framePrin.setContentPane(new Principal().principal);
        framePrin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        framePrin.setVisible(true);
    }
}
