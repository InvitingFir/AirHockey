package com.roman.AirHockey.Main;

import javax.swing.*;

public class Main {
    public static final int WIDTH = 400;
    public static final int HEIGHT = 600;


    public static void main(String[] args) {
        JFrame frame = new JFrame("Air Hockey");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.getContentPane().add(new MainPanel());
        frame.setSize(WIDTH, HEIGHT);
        frame.pack();
        frame.setVisible(true);
    }
}