package com.rawrysmode.entities.employee;

import com.rawrysmode.entities.Dao;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

import static com.rawrysmode.utils.HibernateUtils.getSessionFactory;

public class EmployeeDao implements Dao<Employee> {
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
    public List<Employee> findAll() {
        return getCurrentSession().createQuery("from Employee order by id ASC", Employee.class).getResultList();
    }

    @Override
    public List<Employee> findWhere(String s) {
        return getCurrentSession().createQuery(
                        "from Employee e where " +
                                "upper(e.firstname) like :param or " +
                                "upper(e.patronymic) like :param or " +
                                "upper(e.lastname) like :param or " +
                                "cast(e.dateOfBirth as string) like :param or " +
                                "upper(e.residentialAddress) like :param or " +
                                "upper(e.job.jobTitle) like :param or " +
                                "cast(e.salary as string) like :param", Employee.class)
                .setParameter("param", "%" + s.toUpperCase() + "%")
                .getResultList();
    }

    @Override
    public Employee findById(Integer id) {
        return getCurrentSession().get(Employee.class, id);
    }

    @Override
    public boolean save(Employee entity) {
        getCurrentSession().persist(entity);
        return true;
    }

    @Override
    public boolean update(Employee entity) {
        getCurrentSession().merge(entity);
        return true;
    }

    @Override
    public boolean delete(Employee entity) {
        getCurrentSession().remove(entity);
        return true;
    }
}