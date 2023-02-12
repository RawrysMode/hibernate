package com.rawrysmode.entities.city;

import com.rawrysmode.entities.Dao;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

import static com.rawrysmode.utils.HibernateUtils.getSessionFactory;

public class CityDao implements Dao<City> {

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
    public List<City> findAll() {
        return getCurrentSession().createQuery("from City order by id ASC", City.class).getResultList();
    }

    @Override
    public List<City> findWhere(String s) {
        return getCurrentSession().createQuery("from City c where upper(c.cityName) like :param", City.class)
                .setParameter("param", "%" + s.toUpperCase() + "%")
                .getResultList();
    }

    @Override
    public City findById(Integer id) {
        return getCurrentSession().get(City.class, id);
    }

    @Override
    public boolean save(City entity) {
        getCurrentSession().persist(entity);
        return true;
    }

    @Override
    public boolean update(City entity) {
        getCurrentSession().merge(entity);
        return true;
    }

    @Override
    public boolean delete(City entity) {
        getCurrentSession().remove(entity);
        return true;
    }

}