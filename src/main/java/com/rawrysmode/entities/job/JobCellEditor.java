package com.rawrysmode.entities.job;

import com.rawrysmode.view.components.CustomComboBox;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class JobCellEditor extends AbstractCellEditor implements TableCellEditor, ActionListener {

    private final ArrayList<Job> jobList;
    private Job job;

    public JobCellEditor() {
        JobService service = new JobService();
        jobList = (ArrayList<Job>) service.findAll();
    }

    @Override
    public Job getCellEditorValue() {
        return job;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        if (value instanceof Job) {
            this.job = (Job) value;
        }

        CustomComboBox<Job> comboBox = new CustomComboBox<>(jobList, this.job);
        comboBox.addActionListener(this);
        return comboBox;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void actionPerformed(ActionEvent e) {
        JComboBox<Job> comboBox = (JComboBox<Job>) e.getSource();
        this.job = (Job) comboBox.getSelectedItem();
    }

}
