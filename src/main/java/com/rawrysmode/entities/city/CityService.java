package com.rawrysmode.entities.city;

import java.util.List;

public class CityService {
    private static CityDao cityDAO;

    public CityService() {
        cityDAO = new CityDao();
    }

    public boolean save(City entity) {
        cityDAO.openCurrentSessionWithTransaction();
        cityDAO.save(entity);
        cityDAO.closeCurrentSessionWithTransaction();
        return true;
    }

    public boolean update(City entity) {
        cityDAO.openCurrentSessionWithTransaction();
        cityDAO.update(entity);
        cityDAO.closeCurrentSessionWithTransaction();
        return true;
    }

    public boolean delete(City entity) {
        cityDAO.openCurrentSessionWithTransaction();
        cityDAO.delete(entity);
        cityDAO.closeCurrentSessionWithTransaction();
        return true;
    }

    public List<City> findAll() {
        cityDAO.openCurrentSession();
        List<City> resultList = cityDAO.findAll();
        cityDAO.closeCurrentSession();
        return resultList;
    }

    public List<City> findWhere(String s) {
        cityDAO.openCurrentSession();
        List<City> resultList = cityDAO.findWhere(s);
        cityDAO.closeCurrentSession();
        return resultList;
    }

    public City findById(Integer id) {
        cityDAO.openCurrentSession();
        City result = cityDAO.findById(id);
        cityDAO.closeCurrentSession();
        return result;
    }
}