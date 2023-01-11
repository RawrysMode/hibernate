package com.rawrysmode.entities.order;

import com.rawrysmode.entities.Dao;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

import static com.rawrysmode.utils.HibernateUtils.getSessionFactory;

public class OrderDao implements Dao<Order> {
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
    public List<Order> findAll() {
        return getCurrentSession().createQuery("from Order", Order.class).getResultList();
    }

    @Override
    public List<Order> findWhere(String s) {
        return getCurrentSession().createQuery(
                        "from Order o where " +
                                "upper(o.client.companyName) like :param or " +
                                "upper(o.employee.firstname) like :param or " +
                                "upper(o.employee.lastname) like :param or " +
                                "cast(o.orderDate as string) like :param or " +
                                "upper(o.route.departureCity) like :param or " +
                                "upper(o.route.destinationCity) like :param or " +
                                "cast(o.wagonNumber as string) like :param or " +
                                "cast(o.shippingDate as string) like :param or " +
                                "cast(o.shippingCost as string) like :param or " +
                                "upper(o.nvc) like :param", Order.class)
                .setParameter("param", "%" + s.toUpperCase() + "%")
                .getResultList();
    }

    @Override
    public Order findById(Integer id) {
        return getCurrentSession().get(Order.class, id);
    }

    @Override
    public boolean save(Order entity) {
        getCurrentSession().persist(entity);
        return true;
    }

    @Override
    public boolean update(Order entity) {
        getCurrentSession().merge(entity);
        return true;
    }

    @Override
    public boolean delete(Order entity) {
        getCurrentSession().remove(entity);
        return true;
    }
}