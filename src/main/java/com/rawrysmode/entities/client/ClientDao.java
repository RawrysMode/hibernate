package com.rawrysmode.entities.client;

import com.rawrysmode.entities.Dao;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

import static com.rawrysmode.utils.HibernateUtils.getSessionFactory;

public class ClientDao implements Dao<Client> {
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
    public List<Client> findAll() {
        return getCurrentSession().createQuery("from Client", Client.class).getResultList();
    }

    @Override
    public List<Client> findWhere(String s) {
        return getCurrentSession().createQuery(
                        "from Client c where " +
                                "upper(c.companyName) like :param or " +
                                "upper(c.postalAddress) like :param or " +
                                "upper(c.phoneNumber) like :param or " +
                                "upper(c.faxNumber) like :param or " +
                                "upper(c.email) like :param", Client.class)
                .setParameter("param", "%" + s.toUpperCase() + "%")
                .getResultList();
    }

    @Override
    public Client findById(Integer id) {
        return getCurrentSession().get(Client.class, id);
    }

    @Override
    public boolean save(Client entity) {
        getCurrentSession().persist(entity);
        return true;
    }

    @Override
    public boolean update(Client entity) {
        getCurrentSession().merge(entity);
        return true;
    }

    @Override
    public boolean delete(Client entity) {
        getCurrentSession().remove(entity);
        return true;
    }
}