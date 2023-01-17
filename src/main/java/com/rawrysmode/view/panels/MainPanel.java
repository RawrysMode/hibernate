package com.rawrysmode.view.panels;


import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {

    protected static final Color GREY_COLOR = new Color(0x3C3F41);
    protected static final Color DARK_GREY_COLOR = new Color(0x2b2b2b);
    protected static final Color LIGHT_GREY_COLOR = new Color(0xA9B7C6);

    public MainPanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        TableHolderPanel tableHolderPanel = new TableHolderPanel();

        LeftPanel leftPanel = new LeftPanel(tableHolderPanel);
        this.add(leftPanel);
        RightPanel rightPanel = new RightPanel(tableHolderPanel);
        this.add(rightPanel);
    }
}
