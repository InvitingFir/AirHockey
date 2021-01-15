package com.roman.AirHockey.Main;

import javax.swing.*;

/**
 * todo Document type MainFrame
 */
public class MainFrame extends JFrame {

    private JPanel mainPanel;

    public MainFrame(String title) {
        super(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setSize(WIDTH, HEIGHT);
    }

    public void addMainPanel() {
        this.getContentPane().add(mainPanel);
        pack();
        setVisible(true);
    }

    public void setMainPanel(JPanel mainPanel) {
        this.mainPanel = mainPanel;
    }
}
