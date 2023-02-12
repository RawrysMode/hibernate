package com.rawrysmode.view;

import com.rawrysmode.utils.FontsConfigurator;
import com.rawrysmode.view.panels.MainPanel;

import javax.swing.*;

public class App extends JFrame {

    public App() {
        new FontsConfigurator();

        this.setTitle("Test");
        this.setSize(1200, 700);
        this.setLocationRelativeTo(null);
        this.setContentPane(new MainPanel());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

}
