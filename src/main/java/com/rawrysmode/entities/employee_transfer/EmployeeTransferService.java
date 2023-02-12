package com.rawrysmode.entities.employee_transfer;

import java.util.List;

public class EmployeeTransferService {

    private static EmployeeTransferDao employeeTransferDAO;

    public EmployeeTransferService() {
        employeeTransferDAO = new EmployeeTransferDao();
    }

    public boolean save(EmployeeTransfer entity) {
        employeeTransferDAO.openCurrentSessionWithTransaction();
        employeeTransferDAO.save(entity);
        employeeTransferDAO.closeCurrentSessionWithTransaction();
        return true;
    }

    public void update(EmployeeTransfer entity) {
        employeeTransferDAO.openCurrentSessionWithTransaction();
        employeeTransferDAO.update(entity);
        employeeTransferDAO.closeCurrentSessionWithTransaction();
    }

    public void delete(EmployeeTransfer entity) {
        employeeTransferDAO.openCurrentSessionWithTransaction();
        employeeTransferDAO.delete(entity);
        employeeTransferDAO.closeCurrentSessionWithTransaction();
    }

    public List<EmployeeTransfer> findAll() {
        employeeTransferDAO.openCurrentSession();
        List<EmployeeTransfer> resultList = employeeTransferDAO.findAll();
        employeeTransferDAO.closeCurrentSession();
        return resultList;
    }

    public List<EmployeeTransfer> findWhere(String s) {
        employeeTransferDAO.openCurrentSession();
        List<EmployeeTransfer> resultList = employeeTransferDAO.findWhere(s);
        employeeTransferDAO.closeCurrentSession();
        return resultList;
    }

    public EmployeeTransfer findById(Integer id) {
        employeeTransferDAO.openCurrentSession();
        EmployeeTransfer result = employeeTransferDAO.findById(id);
        employeeTransferDAO.closeCurrentSession();
        return result;
    }

}