package com.rawrysmode.entities.bank_detail;

import java.util.List;

public class BankDetailService {
    private static BankDetailDao bankDetailDAO;

    public BankDetailService() {
        bankDetailDAO = new BankDetailDao();
    }

    public boolean save(BankDetail entity) {
        bankDetailDAO.openCurrentSessionWithTransaction();
        bankDetailDAO.save(entity);
        bankDetailDAO.closeCurrentSessionWithTransaction();
        return true;
    }

    public boolean update(BankDetail entity) {
        bankDetailDAO.openCurrentSessionWithTransaction();
        bankDetailDAO.update(entity);
        bankDetailDAO.closeCurrentSessionWithTransaction();
        return true;
    }

    public boolean delete(BankDetail entity) {
        bankDetailDAO.openCurrentSessionWithTransaction();
        bankDetailDAO.delete(entity);
        bankDetailDAO.closeCurrentSessionWithTransaction();
        return true;
    }

    public List<BankDetail> findAll() {
        bankDetailDAO.openCurrentSession();
        List<BankDetail> resultList = bankDetailDAO.findAll();
        bankDetailDAO.closeCurrentSession();
        return resultList;
    }

    public List<BankDetail> findWhere(String s) {
        bankDetailDAO.openCurrentSession();
        List<BankDetail> resultList = bankDetailDAO.findWhere(s);
        bankDetailDAO.closeCurrentSession();
        return resultList;
    }

    public BankDetail findById(Integer id) {
        bankDetailDAO.openCurrentSession();
        BankDetail result = bankDetailDAO.findById(id);
        bankDetailDAO.closeCurrentSession();
        return result;
    }
}