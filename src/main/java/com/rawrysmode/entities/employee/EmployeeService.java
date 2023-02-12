package com.rawrysmode.entities.employee;

import java.util.List;

public class EmployeeService {

    private static EmployeeDao employeeDAO;

    public EmployeeService() {
        employeeDAO = new EmployeeDao();
    }

    public boolean save(Employee entity) {
        employeeDAO.openCurrentSessionWithTransaction();
        employeeDAO.save(entity);
        employeeDAO.closeCurrentSessionWithTransaction();
        return true;
    }

    public void update(Employee entity) {
        employeeDAO.openCurrentSessionWithTransaction();
        employeeDAO.update(entity);
        employeeDAO.closeCurrentSessionWithTransaction();
    }

    public void delete(Employee entity) {
        employeeDAO.openCurrentSessionWithTransaction();
        employeeDAO.delete(entity);
        employeeDAO.closeCurrentSessionWithTransaction();
    }

    public List<Employee> findAll() {
        employeeDAO.openCurrentSession();
        List<Employee> resultList = employeeDAO.findAll();
        employeeDAO.closeCurrentSession();
        return resultList;
    }

    public List<Employee> findWhere(String s) {
        employeeDAO.openCurrentSession();
        List<Employee> resultList = employeeDAO.findWhere(s);
        employeeDAO.closeCurrentSession();
        return resultList;
    }

    public Employee findById(Integer id) {
        employeeDAO.openCurrentSession();
        Employee result = employeeDAO.findById(id);
        employeeDAO.closeCurrentSession();
        return result;
    }

}