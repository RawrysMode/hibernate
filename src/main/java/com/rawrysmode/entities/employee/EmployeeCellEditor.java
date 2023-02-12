package com.rawrysmode.entities.employee;

import com.rawrysmode.view.components.CustomComboBox;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class EmployeeCellEditor extends AbstractCellEditor implements TableCellEditor, ActionListener {

    private final ArrayList<Employee> employeeList;
    private Employee employee;

    public EmployeeCellEditor() {
        EmployeeService service = new EmployeeService();
        employeeList = (ArrayList<Employee>) service.findAll();
    }

    @Override
    public Employee getCellEditorValue() {
        return employee;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        if (value instanceof Employee) {
            this.employee = (Employee) value;
        }

        CustomComboBox<Employee> comboBox = new CustomComboBox<>(employeeList, this.employee);
        comboBox.addActionListener(this);
        return comboBox;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void actionPerformed(ActionEvent e) {
        JComboBox<Employee> comboBox = (JComboBox<Employee>) e.getSource();
        this.employee = (Employee) comboBox.getSelectedItem();
    }

}
