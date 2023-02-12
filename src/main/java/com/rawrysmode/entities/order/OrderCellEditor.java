package com.rawrysmode.entities.order;

import com.rawrysmode.view.components.CustomComboBox;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class OrderCellEditor extends AbstractCellEditor implements TableCellEditor, ActionListener {

    private final ArrayList<Order> orderList;
    private Order order;

    public OrderCellEditor() {
        OrderService service = new OrderService();
        orderList = (ArrayList<Order>) service.findAll();
    }

    @Override
    public Order getCellEditorValue() {
        return order;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        if (value instanceof Order) {
            this.order = (Order) value;
        }

        CustomComboBox<Order> comboBox = new CustomComboBox<>(orderList, this.order);
        comboBox.addActionListener(this);
        return comboBox;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void actionPerformed(ActionEvent e) {
        JComboBox<Order> comboBox = (JComboBox<Order>) e.getSource();
        this.order = (Order) comboBox.getSelectedItem();
    }

}
