package com.rawrysmode.view.panels;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class TableHolder extends JPanel {

    JTable table = new JTable();
    JScrollPane jScrollPane = new JScrollPane(table);

    TableHolder() {
        this.setLayout(new BorderLayout());
//        this.setPreferredSize(new Dimension(800, 700 - 30));
        this.setBackground(MainPanel.DARK_GREY_COLOR);

        table.setDefaultRenderer(String.class, new TableCellsRenderer());
        table.getTableHeader().setDefaultRenderer(new TableHeaderRenderer());
        table.setGridColor(MainPanel.GREY_COLOR);

        jScrollPane.getViewport().setBackground(MainPanel.DARK_GREY_COLOR);
        jScrollPane.setBorder(BorderFactory.createEmptyBorder());

        this.add(jScrollPane, BorderLayout.CENTER);
    }

    private static class TableHeaderRenderer extends JLabel implements TableCellRenderer {
        TableHeaderRenderer() {
            setOpaque(true);
            setForeground(MainPanel.LIGHT_GREY_COLOR);
            setBackground(MainPanel.GREY_COLOR);
            setHorizontalAlignment(JLabel.CENTER);
            setBorder(BorderFactory.createLineBorder(MainPanel.GREY_COLOR));
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setText(value.toString());
            return this;
        }
    }

    private static class TableCellsRenderer extends JLabel implements TableCellRenderer {
        TableCellsRenderer() {
            setOpaque(true);
            setFont(new Font("JetBrains Mono NL Bold", Font.PLAIN, 12));
            setBackground(MainPanel.DARK_GREY_COLOR);
            setForeground(MainPanel.LIGHT_GREY_COLOR);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setText(value.toString());
            return this;
        }
    }
}
