package com.rawrysmode.entities.city;

import com.rawrysmode.view.components.CustomComboBox;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CityCellEditor extends AbstractCellEditor implements TableCellEditor, ActionListener {

    private final ArrayList<City> cityList;
    private City city;

    public CityCellEditor() {
        CityService service = new CityService();
        cityList = (ArrayList<City>) service.findAll();
    }

    @Override
    public City getCellEditorValue() {
        return city;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        if (value instanceof City) {
            this.city = (City) value;
        }

        CustomComboBox<City> comboBox = new CustomComboBox<>(cityList, this.city);
        comboBox.addActionListener(this);
        return comboBox;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void actionPerformed(ActionEvent e) {
        JComboBox<City> comboBox = (JComboBox<City>) e.getSource();
        this.city = (City) comboBox.getSelectedItem();
    }

}
