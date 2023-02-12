package com.rawrysmode.entities.job;

import com.rawrysmode.entities.CustomTableModel;
import com.rawrysmode.entities.TableEntity;

import java.util.List;

public class JobTableModel extends CustomTableModel<Job> {

    private final JobService jobService;
    private List<TableEntity<Job>> jobList;

    public JobTableModel() {
        jobService = new JobService();
        jobList = wrapList(jobService.findAll());
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
        return jobList.get(rowIndex).getEntity().getJobTitle();
    }

    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        jobList.get(rowIndex).getEntity().setJobTitle((String) aValue);
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

    @Override
    public void findWhere(String request) {
        jobList = wrapList(jobService.findWhere(request));
        fireTableDataChanged();
    }

    @Override
    public void createRow() {
        jobList.add(new TableEntity<>(new Job(), true));
        fireTableDataChanged();
    }

    @Override
    public void removeRow(int rowIndex) {
        jobService.delete(jobList.remove(rowIndex).getEntity());
        fireTableRowsDeleted(rowIndex, rowIndex);
    }


    @Override
    public boolean hasChanged(int row) {
        return jobList.get(row).hasChanged();
    }

    @Override
    public void setHasChanged(int row) {
        jobList.get(row).setHasChanged(true);
    }

    @Override
    public boolean isCreated(int row) {
        return jobList.get(row).isCreated();
    }

    @Override
    public void setCreated(int row) {
        jobList.get(row).setCreated(true);
    }

    @Override
    public void save(int[] rows) {
        for (int row : rows) {
            TableEntity<Job> tableEntity = jobList.get(row);
            if (tableEntity.isCreated() || tableEntity.hasChanged()) {
                jobService.update(tableEntity.getEntity());
                tableEntity.setCreated(false);
                tableEntity.setHasChanged(false);
            }
        }
    }

}
