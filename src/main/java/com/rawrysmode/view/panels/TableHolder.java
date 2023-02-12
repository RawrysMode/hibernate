package com.rawrysmode.view.panels;

import com.rawrysmode.assets.colors.CustomColors;
import com.rawrysmode.view.components.CustomTable;

import javax.swing.*;
import java.awt.*;

public class TableHolder extends JPanel {

    protected final JScrollPane jScrollPane;

    TableHolder(CustomTable customTable) {
        this.setLayout(new BorderLayout());
        this.setBackground(CustomColors.DARK_GREY_COLOR);

        jScrollPane = new JScrollPane(customTable);
        jScrollPane.getViewport().setBackground(CustomColors.DARK_GREY_COLOR);
        jScrollPane.setBorder(BorderFactory.createEmptyBorder());
        this.add(jScrollPane, BorderLayout.NORTH);
    }

}
