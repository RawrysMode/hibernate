package com.rawrysmode.entities.employee;

import com.rawrysmode.entities.job.Job;

import javax.swing.table.AbstractTableModel;
import java.time.LocalDate;
import java.util.List;

public class EmployeeTableModel extends AbstractTableModel {
    private final EmployeeService employeeService;
    private final List<Employee> employeeList;

    public EmployeeTableModel() {
        employeeService = new EmployeeService();
        employeeList = employeeService.findAll();
    }

    @Override
    public int getRowCount() {
        return employeeList.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return getValueAt(0, columnIndex).getClass();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return switch (columnIndex) {
            case 0 -> employeeList.get(rowIndex).getFirstname();
            case 1 -> employeeList.get(rowIndex).getPatronymic();
            case 2 -> employeeList.get(rowIndex).getLastname();
            case 3 -> employeeList.get(rowIndex).getDateOfBirth();
            case 4 -> employeeList.get(rowIndex).getResidentialAddress();
            case 5 -> employeeList.get(rowIndex).getJob();
            case 6 -> employeeList.get(rowIndex).getSalary();
            default -> "Not found";
        };
    }

    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0 -> {
                employeeList.get(rowIndex).setFirstname((String) aValue);
                employeeService.update(employeeList.get(rowIndex));
            }
            case 1 -> {
                employeeList.get(rowIndex).setPatronymic((String) aValue);
                employeeService.update(employeeList.get(rowIndex));
            }
            case 2 -> {
                employeeList.get(rowIndex).setLastname((String) aValue);
                employeeService.update(employeeList.get(rowIndex));
            }
            case 3 -> {
                employeeList.get(rowIndex).setDateOfBirth(LocalDate.parse((String) aValue));
                employeeService.update(employeeList.get(rowIndex));
            }
            case 4 -> {
                employeeList.get(rowIndex).setResidentialAddress((String) aValue);
                employeeService.update(employeeList.get(rowIndex));
            }
            case 5 -> {
                employeeList.get(rowIndex).setJob((Job) aValue);
                employeeService.update(employeeList.get(rowIndex));
            }
            case 6 -> {
                employeeList.get(rowIndex).setSalary((Integer) aValue);
                employeeService.update(employeeList.get(rowIndex));
            }
        }
        fireTableDataChanged();
    }

    @Override
    public String getColumnName(int column) {
        return switch (column) {
            case 0 -> "Имя";
            case 1 -> "Отчество";
            case 2 -> "Фамилия";
            case 3 -> "Дата рождения";
            case 4 -> "Место жительства";
            case 5 -> "Должность";
            case 6 -> "Зарплата";
            default -> "";
        };
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }
}
