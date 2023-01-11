package com.rawrysmode.entities.bank_detail;

import com.rawrysmode.entities.Dao;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

import static com.rawrysmode.utils.HibernateUtils.getSessionFactory;

public class BankDetailDao implements Dao<BankDetail> {
    private Session currentSession;
    private Transaction currentTransaction;

    public void openCurrentSession() {
        currentSession = getSessionFactory().openSession();
    }

    public void closeCurrentSession() {
        currentSession.close();
    }

    public Session getCurrentSession() {
        return currentSession;
    }

    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }

    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }

    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }

    public void openCurrentSessionWithTransaction() {
        currentSession = getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
    }

    public void closeCurrentSessionWithTransaction() {
        currentTransaction.commit();
        currentSession.close();
    }

    @Override
    public List<BankDetail> findAll() {
        return getCurrentSession().createQuery("from BankDetail", BankDetail.class).getResultList();
    }

    @Override
    public List<BankDetail> findWhere(String s) {
        return getCurrentSession().createQuery("from BankDetail bd where " +
                        "upper(bd.client.companyName) like :param or " +
                        "upper(bd.bankName) like :param or " +
                        "upper(bd.city.cityName) like :param or " +
                        "upper(bd.tin) like :param or " +
                        "upper(bd.bankAccount) like :param", BankDetail.class)
                .setParameter("param", "%" + s.toUpperCase() + "%")
                .getResultList();
    }

    @Override
    public BankDetail findById(Integer id) {
        return getCurrentSession().get(BankDetail.class, id);
    }

    @Override
    public boolean save(BankDetail entity) {
        getCurrentSession().persist(entity);
        return true;
    }

    @Override
    public boolean update(BankDetail entity) {
        getCurrentSession().merge(entity);
        return true;
    }

    @Override
    public boolean delete(BankDetail entity) {
        getCurrentSession().remove(entity);
        return true;
    }
}