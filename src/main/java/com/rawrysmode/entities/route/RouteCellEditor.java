package com.rawrysmode.entities.route;

import com.rawrysmode.view.components.CustomComboBox;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class RouteCellEditor extends AbstractCellEditor implements TableCellEditor, ActionListener {

    private final ArrayList<Route> routeList;
    private Route route;

    public RouteCellEditor() {
        RouteService service = new RouteService();
        routeList = (ArrayList<Route>) service.findAll();
    }

    @Override
    public Route getCellEditorValue() {
        return route;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        if (value instanceof Route) {
            this.route = (Route) value;
        }

        CustomComboBox<Route> comboBox = new CustomComboBox<>(routeList, this.route);
        comboBox.addActionListener(this);
        return comboBox;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void actionPerformed(ActionEvent e) {
        JComboBox<Route> comboBox = (JComboBox<Route>) e.getSource();
        this.route = (Route) comboBox.getSelectedItem();
    }

}
