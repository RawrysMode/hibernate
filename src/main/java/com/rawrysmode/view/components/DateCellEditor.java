package com.rawrysmode.view.components;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.time.LocalDate;

public class DateCellEditor extends AbstractCellEditor implements TableCellEditor {

    private String string;

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        if (value instanceof LocalDate) {
            this.string = String.valueOf(value);
        }

        JTextField jTextField = new CustomTextField();
        jTextField.addActionListener(e -> string = jTextField.getText());
        return jTextField;
    }

    @Override
    public String getCellEditorValue() {
        return this.string;
    }

}
