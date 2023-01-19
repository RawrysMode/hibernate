package com.rawrysmode.view.panels;


import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {

    protected static final Color LIGHT_GREY_COLOR = new Color(0xA9B7C6);
    protected static final Color GREY_COLOR = new Color(0x3C3F41);
    protected static final Color DARK_GREY_COLOR = new Color(0x2b2b2b);

    public MainPanel() {
        this.setLayout(new BorderLayout());

        TableHolder tableHolder = new TableHolder();
        this.add(tableHolder, BorderLayout.CENTER);
        OptionsHolder optionsHolder = new OptionsHolder(tableHolder);
        this.add(optionsHolder, BorderLayout.NORTH);
        ListHolder listHolder = new ListHolder(tableHolder);
        this.add(listHolder, BorderLayout.WEST);
    }
}
