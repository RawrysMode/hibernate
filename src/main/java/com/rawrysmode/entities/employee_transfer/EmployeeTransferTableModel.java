package com.rawrysmode.entities.employee_transfer;

import com.rawrysmode.entities.employee.Employee;
import com.rawrysmode.entities.job.Job;

import javax.swing.table.AbstractTableModel;
import java.time.LocalDate;
import java.util.List;

public class EmployeeTransferTableModel extends AbstractTableModel {
    private final EmployeeTransferService employeeTransferService;
    private final List<EmployeeTransfer> employeeTransferList;

    public EmployeeTransferTableModel() {
        employeeTransferService = new EmployeeTransferService();
        employeeTransferList = employeeTransferService.findAll();
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
            case 0 -> employeeTransferList.get(rowIndex).getEmployee();
            case 1 -> employeeTransferList.get(rowIndex).getTransferReason();
            case 2 -> employeeTransferList.get(rowIndex).getOldJob();
            case 3 -> employeeTransferList.get(rowIndex).getNewJob();
            case 4 -> employeeTransferList.get(rowIndex).getOrderNumber();
            case 5 -> employeeTransferList.get(rowIndex).getOrderDate();
            default -> "Not found";
        };
    }

    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0 -> {
                employeeTransferList.get(rowIndex).setEmployee((Employee) aValue);
                employeeTransferService.update(employeeTransferList.get(rowIndex));
            }
            case 1 -> {
                employeeTransferList.get(rowIndex).setTransferReason((String) aValue);
                employeeTransferService.update(employeeTransferList.get(rowIndex));
            }
            case 2 -> {
                employeeTransferList.get(rowIndex).setOldJob((Job) aValue);
                employeeTransferService.update(employeeTransferList.get(rowIndex));
            }
            case 3 -> {
                employeeTransferList.get(rowIndex).setNewJob((Job) aValue);
                employeeTransferService.update(employeeTransferList.get(rowIndex));
            }
            case 4 -> {
                employeeTransferList.get(rowIndex).setOrderNumber((Integer) aValue);
                employeeTransferService.update(employeeTransferList.get(rowIndex));
            }
            case 5 -> {
                employeeTransferList.get(rowIndex).setOrderDate(LocalDate.parse((String) aValue));
                employeeTransferService.update(employeeTransferList.get(rowIndex));
            }
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
}
