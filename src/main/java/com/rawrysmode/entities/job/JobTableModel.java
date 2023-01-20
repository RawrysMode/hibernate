package com.rawrysmode.entities.job;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class JobTableModel extends AbstractTableModel {

    private final JobService jobService;
    private final List<Job> jobList;

    public JobTableModel() {
        jobService = new JobService();
        jobList = jobService.findAll();
    }

    @Override
    public int getRowCount() {
        return jobList.size();
    }

    @Override
    public int getColumnCount() {
        return 1;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return getValueAt(0, columnIndex).getClass();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return jobList.get(rowIndex).getJobTitle();
    }

    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        jobList.get(rowIndex).setJobTitle((String) aValue);
        jobService.update(jobList.get(rowIndex));
        fireTableDataChanged();
    }

    @Override
    public String getColumnName(int column) {
        return "Название должности";
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }
}
