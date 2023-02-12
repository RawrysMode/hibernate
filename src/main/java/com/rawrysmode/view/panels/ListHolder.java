package com.rawrysmode.view.panels;

import com.rawrysmode.assets.colors.CustomColors;
import com.rawrysmode.entities.TableModelsFactory;
import com.rawrysmode.view.components.CustomTable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ListHolder extends JPanel {

    public static boolean isEnabled = true;

    protected ListHolder(CustomTable customTable) {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(250, 0));
        setBackground(CustomColors.GREY_COLOR);

        JList<String> tableNamesList = createTableNamesList();

        tableNamesList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2 && isEnabled) {
                    customTable.setModel(TableModelsFactory
                            .getBuilderByName(tableNamesList.getSelectedValue()));
                }
            }
        });
        add(tableNamesList, BorderLayout.CENTER);
    }

    private static JList<String> createTableNamesList() {
        JList<String> tableNamesList = new JList<>(TableModelsFactory.getTableNames());
        tableNamesList.setCellRenderer(new ListRenderer());
        tableNamesList.setFixedCellWidth(385);
        tableNamesList.setBackground(CustomColors.GREY_COLOR);
        tableNamesList.setForeground(CustomColors.LIGHT_GREY_COLOR);
        return tableNamesList;
    }

    private static class ListRenderer extends DefaultListCellRenderer {

        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            JLabel label = (JLabel) super.getListCellRendererComponent(
                    list, value, index, isSelected, cellHasFocus);
            label.setIcon(new ImageIcon("src/main/java/com/rawrysmode/assets/icons/filler.png"));
            label.setHorizontalTextPosition(JLabel.RIGHT);
            label.setFont(new Font("JetBrains Mono Medium", Font.PLAIN, 12));
            return label;
        }

    }

}
