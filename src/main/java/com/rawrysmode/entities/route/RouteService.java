package com.rawrysmode.entities.route;

import java.util.List;

public class RouteService {

    private static RouteDao routeDAO;

    public RouteService() {
        routeDAO = new RouteDao();
    }

    public boolean save(Route entity) {
        routeDAO.openCurrentSessionWithTransaction();
        routeDAO.save(entity);
        routeDAO.closeCurrentSessionWithTransaction();
        return true;
    }

    public void update(Route entity) {
        routeDAO.openCurrentSessionWithTransaction();
        routeDAO.update(entity);
        routeDAO.closeCurrentSessionWithTransaction();
    }

    public void delete(Route entity) {
        routeDAO.openCurrentSessionWithTransaction();
        routeDAO.delete(entity);
        routeDAO.closeCurrentSessionWithTransaction();
    }

    public List<Route> findAll() {
        routeDAO.openCurrentSession();
        List<Route> resultList = routeDAO.findAll();
        routeDAO.closeCurrentSession();
        return resultList;
    }

    public List<Route> findWhere(String s) {
        routeDAO.openCurrentSession();
        List<Route> resultList = routeDAO.findWhere(s);
        routeDAO.closeCurrentSession();
        return resultList;
    }

    public Route findById(Integer id) {
        routeDAO.openCurrentSession();
        Route result = routeDAO.findById(id);
        routeDAO.closeCurrentSession();
        return result;
    }

}