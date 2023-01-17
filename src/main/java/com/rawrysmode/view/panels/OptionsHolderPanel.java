package com.rawrysmode.view.panels;

import javax.swing.*;
import java.awt.*;

public class OptionsHolderPanel extends JPanel {
    OptionsHolderPanel(TableHolderPanel tableHolderPanel) {
        this.setLayout(new FlowLayout(FlowLayout.LEFT));

        JButton addRowButton = new JButton("Add row");
        addRowButton.setForeground(MainPanel.LIGHT_GREY_COLOR);

        addRowButton.setBorderPainted(false);
        addRowButton.setContentAreaFilled(false);
        addRowButton.setFocusPainted(false);
        addRowButton.setPreferredSize(new Dimension(80, 20));

        this.add(addRowButton);

        this.setBackground(MainPanel.GREY_COLOR);
        this.setPreferredSize(new Dimension(800, 30));
    }
}
