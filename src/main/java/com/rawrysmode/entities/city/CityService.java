package com.rawrysmode.entities.city;

import java.util.List;

public class CityService {

    private static CityDao cityDAO;

    public CityService() {
        cityDAO = new CityDao();
    }

    public void save(City entity) {
        cityDAO.openCurrentSessionWithTransaction();
        cityDAO.save(entity);
        cityDAO.closeCurrentSessionWithTransaction();
    }

    public void update(City entity) {
        cityDAO.openCurrentSessionWithTransaction();
        cityDAO.update(entity);
        cityDAO.closeCurrentSessionWithTransaction();
    }

    public void delete(City entity) {
        cityDAO.openCurrentSessionWithTransaction();
        cityDAO.delete(entity);
        cityDAO.closeCurrentSessionWithTransaction();
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