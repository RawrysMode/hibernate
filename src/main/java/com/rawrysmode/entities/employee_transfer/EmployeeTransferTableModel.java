package com.rawrysmode.entities.employee_transfer;

import com.rawrysmode.entities.CustomTableModel;
import com.rawrysmode.entities.TableEntity;
import com.rawrysmode.entities.employee.Employee;
import com.rawrysmode.entities.job.Job;

import java.time.LocalDate;
import java.util.List;

public class EmployeeTransferTableModel extends CustomTableModel<EmployeeTransfer> {

    private final EmployeeTransferService employeeTransferService;
    private List<TableEntity<EmployeeTransfer>> employeeTransferList;

    public EmployeeTransferTableModel() {
        employeeTransferService = new EmployeeTransferService();
        employeeTransferList = wrapList(employeeTransferService.findAll());
    }

    @Override
    public int getRowCount() {
        return employeeTransferList.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return getValueAt(0, columnIndex).getClass();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return switch (columnIndex) {
            case 0 -> employeeTransferList.get(rowIndex).getEntity().getEmployee();
            case 1 -> employeeTransferList.get(rowIndex).getEntity().getTransferReason();
            case 2 -> employeeTransferList.get(rowIndex).getEntity().getOldJob();
            case 3 -> employeeTransferList.get(rowIndex).getEntity().getNewJob();
            case 4 -> employeeTransferList.get(rowIndex).getEntity().getOrderNumber();
            case 5 -> employeeTransferList.get(rowIndex).getEntity().getOrderDate();
            default -> "Not found";
        };
    }

    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0 -> employeeTransferList.get(rowIndex).getEntity().setEmployee((Employee) aValue);
            case 1 -> employeeTransferList.get(rowIndex).getEntity().setTransferReason((String) aValue);
            case 2 -> employeeTransferList.get(rowIndex).getEntity().setOldJob((Job) aValue);
            case 3 -> employeeTransferList.get(rowIndex).getEntity().setNewJob((Job) aValue);
            case 4 -> employeeTransferList.get(rowIndex).getEntity().setOrderNumber((Integer) aValue);
            case 5 -> employeeTransferList.get(rowIndex).getEntity().setOrderDate(LocalDate.parse((String) aValue));
        }
        fireTableDataChanged();
    }

    @Override
    public String getColumnName(int column) {
        return switch (column) {
            case 0 -> "Сотрудник";
            case 1 -> "Причина";
            case 2 -> "Старая должность";
            case 3 -> "Новая должность";
            case 4 -> "Номер приказа";
            case 5 -> "Дата перевода";
            default -> "";
        };
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public void findWhere(String request) {
        employeeTransferList = wrapList(employeeTransferService.findWhere(request));
        fireTableDataChanged();
    }

    @Override
    public void createRow() {
        employeeTransferList.add(new TableEntity<>(new EmployeeTransfer(), true));
        fireTableDataChanged();
    }

    @Override
    public void removeRow(int rowIndex) {
        employeeTransferService.delete(employeeTransferList.remove(rowIndex).getEntity());
        fireTableRowsDeleted(rowIndex, rowIndex);
    }


    @Override
    public boolean hasChanged(int row) {
        return employeeTransferList.get(row).hasChanged();
    }

    @Override
    public void setHasChanged(int row) {
        employeeTransferList.get(row).setHasChanged(true);
    }

    @Override
    public boolean isCreated(int row) {
        return employeeTransferList.get(row).isCreated();
    }

    @Override
    public void setCreated(int row) {
        employeeTransferList.get(row).setCreated(true);
    }

    @Override
    public void save(int[] rows) {
        for (int row : rows) {
            TableEntity<EmployeeTransfer> tableEntity = employeeTransferList.get(row);
            if (tableEntity.isCreated() || tableEntity.hasChanged()) {
                employeeTransferService.update(tableEntity.getEntity());
                tableEntity.setCreated(false);
                tableEntity.setHasChanged(false);
            }
        }
    }

}
