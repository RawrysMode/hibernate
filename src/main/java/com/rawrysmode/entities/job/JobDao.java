package com.rawrysmode.entities.job;

import com.rawrysmode.entities.Dao;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

import static com.rawrysmode.utils.HibernateUtils.getSessionFactory;

public class JobDao implements Dao<Job> {

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

    public void openCurrentSessionWithTransaction() {
        currentSession = getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
    }

    public void closeCurrentSessionWithTransaction() {
        currentTransaction.commit();
        currentSession.close();
    }

    @Override
    public List<Job> findAll() {
        return getCurrentSession().createQuery("from Job order by id ASC", Job.class).getResultList();
    }

    @Override
    public List<Job> findWhere(String s) {
        return getCurrentSession().createQuery("from Job c where upper(c.jobTitle) like :param", Job.class)
                .setParameter("param", "%" + s.toUpperCase() + "%")
                .getResultList();
    }

    @Override
    public Job findById(Integer id) {
        return getCurrentSession().get(Job.class, id);
    }

    @Override
    public boolean save(Job entity) {
        getCurrentSession().persist(entity);
        return true;
    }

    @Override
    public boolean update(Job entity) {
        getCurrentSession().merge(entity);
        return true;
    }

    @Override
    public boolean delete(Job entity) {
        getCurrentSession().remove(entity);
        return true;
    }

}