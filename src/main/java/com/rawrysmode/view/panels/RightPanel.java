package com.rawrysmode.view.panels;

import javax.swing.*;

public class RightPanel extends JPanel {
    RightPanel(TableHolderPanel tableHolderPanel) {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        OptionsHolderPanel optionsHolderPanel = new OptionsHolderPanel(tableHolderPanel);
        this.add(optionsHolderPanel);
        this.add(tableHolderPanel);
    }
}
