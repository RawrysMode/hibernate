package com.rawrysmode.view.panels;


import com.rawrysmode.view.components.CustomTable;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {

    private ListHolder listHolder;
    private OptionsHolder optionsHolder;

    public MainPanel() {
        this.setLayout(new BorderLayout());

        try {
            CustomTable customTable = CustomTable.getInstance();
            TableHolder tableHolder = new TableHolder(customTable);
            this.add(tableHolder, BorderLayout.CENTER);
            listHolder = new ListHolder(customTable);
            this.add(listHolder, BorderLayout.WEST);
            optionsHolder = new OptionsHolder(customTable);
            this.add(optionsHolder, BorderLayout.NORTH);
            customTable.initializeTableCellEditors();
        } catch (NullPointerException e) {
            listHolder.getComponents()[0].setEnabled(false);
            ListHolder.isEnabled = false;
            for (Component component : optionsHolder.getComponents()) {
                component.setEnabled(false);
            }
            JOptionPane.showMessageDialog(this, "Something went wrong with connection\n"
                    + "All options will be disabled for now\n"
                    + "Please, check database connection parameters and try again");
        }
    }

}
