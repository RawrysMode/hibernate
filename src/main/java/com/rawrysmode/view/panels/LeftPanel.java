package com.rawrysmode.view.panels;

import com.rawrysmode.entities.TableModelsFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LeftPanel extends JPanel {
    protected LeftPanel(TableHolderPanel tableHolderPanel) {
        JList<String> tableNamesList = createTableNamesList();
        this.add(tableNamesList);

        tableNamesList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    tableHolderPanel
                            .table.setModel(TableModelsFactory
                                    .getBuilderByName(tableNamesList.getSelectedValue()));
                }
            }
        });

        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 30));
        this.setPreferredSize(new Dimension(250, 0));
        this.setBackground(MainPanel.GREY_COLOR);
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

    private static JList<String> createTableNamesList() {
        JList<String> tableNamesList = new JList<>(TableModelsFactory.getTableNames());
        tableNamesList.setCellRenderer(new ListRenderer());
        tableNamesList.setFixedCellHeight(20);
        tableNamesList.setFixedCellWidth(385);
        tableNamesList.setBackground(MainPanel.GREY_COLOR);
        tableNamesList.setForeground(MainPanel.LIGHT_GREY_COLOR);
        return tableNamesList;
    }
}
