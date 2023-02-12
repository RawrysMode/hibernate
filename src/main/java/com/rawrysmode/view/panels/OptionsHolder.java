package com.rawrysmode.view.panels;

import com.rawrysmode.assets.colors.CustomColors;
import com.rawrysmode.view.components.CustomButton;
import com.rawrysmode.view.components.CustomTable;
import com.rawrysmode.view.components.CustomTextField;

import javax.swing.*;
import java.awt.*;

public class OptionsHolder extends JPanel {

    OptionsHolder(CustomTable customTable) {
        this.setLayout(new FlowLayout(FlowLayout.TRAILING));
        this.setBackground(CustomColors.GREY_COLOR);

        CustomButton removeRowButton = new CustomButton("—", "JetBrains Mono ExtraBold", 15, 15, true);
        removeRowButton.addActionListener(e -> {
            if (customTable.getSelectedRow() != -1) {
                customTable.getCurrentModel().removeRow(customTable.getSelectedRow());
            }
        });
        this.add(removeRowButton);

        CustomButton addRowButton = new CustomButton("+", "JetBrains Mono ExtraBold", 15, 15, true);
        addRowButton.addActionListener(e -> customTable.getCurrentModel().createRow());
        this.add(addRowButton);

        CustomButton updateButton = new CustomButton("o", "JetBrains Mono ExtraBold", 15, 15, true);
        updateButton.addActionListener(e -> customTable.getCurrentModel().save(customTable.getSelectedRows()));
        this.add(updateButton);

        CustomTextField searchTextField = new CustomTextField("", 150, 20);
        searchTextField.addActionListener(e -> {
            customTable.getCurrentModel().findWhere(searchTextField.getText());
        });
        this.add(searchTextField);
    }

}