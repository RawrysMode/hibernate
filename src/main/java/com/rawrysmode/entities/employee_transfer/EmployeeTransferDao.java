package com.rawrysmode.entities.employee_transfer;

import com.rawrysmode.entities.Dao;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

import static com.rawrysmode.utils.HibernateUtils.getSessionFactory;

public class EmployeeTransferDao implements Dao<EmployeeTransfer> {
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
    public List<EmployeeTransfer> findAll() {
        return getCurrentSession().createQuery("from EmployeeTransfer", EmployeeTransfer.class).getResultList();
    }

    @Override
    public List<EmployeeTransfer> findWhere(String s) {
        return getCurrentSession().createQuery("from EmployeeTransfer et where " +
                        "upper(et.employee.firstname) like :param or " +
                        "upper(et.employee.lastname) like :param or " +
                        "upper(et.transferReason) like :param or " +
                        "upper(et.oldJob) like :param or " +
                        "upper(et.newJob) like :param or " +
                        "cast(et.orderNumber as string) like :param or " +
                        "cast(et.orderDate as string) like :param", EmployeeTransfer.class)
                .setParameter("param", "%" + s.toUpperCase() + "%")
                .getResultList();
    }

    @Override
    public EmployeeTransfer findById(Integer id) {
        return getCurrentSession().get(EmployeeTransfer.class, id);
    }

    @Override
    public boolean save(EmployeeTransfer entity) {
        getCurrentSession().persist(entity);
        return true;
    }

    @Override
    public boolean update(EmployeeTransfer entity) {
        getCurrentSession().merge(entity);
        return true;
    }

    @Override
    public boolean delete(EmployeeTransfer entity) {
        getCurrentSession().remove(entity);
        return true;
    }
}