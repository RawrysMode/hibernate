package com.rawrysmode.entities.order_wagon_place;

import com.rawrysmode.entities.Dao;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

import static com.rawrysmode.utils.HibernateUtils.getSessionFactory;

public class OrderWagonPlaceDao implements Dao<OrderWagonPlace> {
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
    public List<OrderWagonPlace> findAll() {
        return getCurrentSession().createQuery("from OrderWagonPlace", OrderWagonPlace.class).getResultList();
    }

    @Override
    public List<OrderWagonPlace> findWhere(String s) {
        return getCurrentSession().createQuery(
                        "from OrderWagonPlace owp where " +
                                "upper(owp.order.client.companyName) like :param or " +
                                "upper(owp.order.wagonNumber) like :param or " +
                                "cast(owp.spaceNumber as string) like :param or " +
                                "upper(owp.size) like :param or " +
                                "upper(owp.weight) like :param or " +
                                "cast(owp.insuranceCost as string) like :param", OrderWagonPlace.class)
                .setParameter("param", "%" + s.toUpperCase() + "%")
                .getResultList();
    }

    @Override
    public OrderWagonPlace findById(Integer id) {
        return getCurrentSession().get(OrderWagonPlace.class, id);
    }

    @Override
    public boolean save(OrderWagonPlace entity) {
        getCurrentSession().persist(entity);
        return true;
    }

    @Override
    public boolean update(OrderWagonPlace entity) {
        getCurrentSession().merge(entity);
        return true;
    }

    @Override
    public boolean delete(OrderWagonPlace entity) {
        getCurrentSession().remove(entity);
        return true;
    }
}