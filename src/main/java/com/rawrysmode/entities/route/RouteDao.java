package com.rawrysmode.entities.route;

import com.rawrysmode.entities.Dao;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

import static com.rawrysmode.utils.HibernateUtils.getSessionFactory;

public class RouteDao implements Dao<Route> {
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
    public List<Route> findAll() {
        return getCurrentSession().createQuery("from Route", Route.class).getResultList();
    }

    @Override
    public List<Route> findWhere(String s) {
        return getCurrentSession().createQuery(
                        "from Route r where " +
                                "upper(r.departureCity) like :param or " +
                                "upper(r.destinationCity) like :param or " +
                                "cast(r.routeCost as string) like :param", Route.class)
                .setParameter("param", "%" + s.toUpperCase() + "%")
                .getResultList();
    }

    @Override
    public Route findById(Integer id) {
        return getCurrentSession().get(Route.class, id);
    }

    @Override
    public boolean save(Route entity) {
        getCurrentSession().persist(entity);
        return true;
    }

    @Override
    public boolean update(Route entity) {
        getCurrentSession().merge(entity);
        return true;
    }

    @Override
    public boolean delete(Route entity) {
        getCurrentSession().remove(entity);
        return true;
    }
}