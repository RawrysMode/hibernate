package com.rawrysmode.entities.employee;

import com.rawrysmode.entities.CustomTableModel;
import com.rawrysmode.entities.TableEntity;
import com.rawrysmode.entities.job.Job;

import java.time.LocalDate;
import java.util.List;

public class EmployeeTableModel extends CustomTableModel<Employee> {

    private final EmployeeService employeeService;
    private List<TableEntity<Employee>> employeeList;

    public EmployeeTableModel() {
        employeeService = new EmployeeService();
        employeeList = wrapList(employeeService.findAll());
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
            case 0 -> employeeList.get(rowIndex).getEntity().getFirstname();
            case 1 -> employeeList.get(rowIndex).getEntity().getPatronymic();
            case 2 -> employeeList.get(rowIndex).getEntity().getLastname();
            case 3 -> employeeList.get(rowIndex).getEntity().getDateOfBirth();
            case 4 -> employeeList.get(rowIndex).getEntity().getResidentialAddress();
            case 5 -> employeeList.get(rowIndex).getEntity().getJob();
            case 6 -> employeeList.get(rowIndex).getEntity().getSalary();
            default -> "Not found";
        };
    }

    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0 -> employeeList.get(rowIndex).getEntity().setFirstname((String) aValue);
            case 1 -> employeeList.get(rowIndex).getEntity().setPatronymic((String) aValue);
            case 2 -> employeeList.get(rowIndex).getEntity().setLastname((String) aValue);
            case 3 -> employeeList.get(rowIndex).getEntity().setDateOfBirth(LocalDate.parse((String) aValue));
            case 4 -> employeeList.get(rowIndex).getEntity().setResidentialAddress((String) aValue);
            case 5 -> employeeList.get(rowIndex).getEntity().setJob((Job) aValue);
            case 6 -> employeeList.get(rowIndex).getEntity().setSalary((Integer) aValue);
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

    @Override
    public void findWhere(String request) {
        employeeList = wrapList(employeeService.findWhere(request));
        fireTableDataChanged();
    }

    @Override
    public void createRow() {
        employeeList.add(new TableEntity<>(new Employee(), true));
        fireTableDataChanged();
    }

    @Override
    public void removeRow(int rowIndex) {
        employeeService.delete(employeeList.remove(rowIndex).getEntity());
        fireTableRowsDeleted(rowIndex, rowIndex);
    }


    @Override
    public boolean hasChanged(int row) {
        return employeeList.get(row).hasChanged();
    }

    @Override
    public void setHasChanged(int row) {
        employeeList.get(row).setHasChanged(true);
    }

    @Override
    public boolean isCreated(int row) {
        return employeeList.get(row).isCreated();
    }

    @Override
    public void setCreated(int row) {
        employeeList.get(row).setCreated(true);
    }

    @Override
    public void save(int[] rows) {
        for (int row : rows) {
            TableEntity<Employee> tableEntity = employeeList.get(row);
            if (tableEntity.isCreated() || tableEntity.hasChanged()) {
                employeeService.update(tableEntity.getEntity());
                tableEntity.setCreated(false);
                tableEntity.setHasChanged(false);
            }
        }
    }

}
