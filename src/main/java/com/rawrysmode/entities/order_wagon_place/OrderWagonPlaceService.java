package com.rawrysmode.entities.order_wagon_place;

import java.util.List;

public class OrderWagonPlaceService {
    private static OrderWagonPlaceDao orderWagonPlaceDAO;

    public OrderWagonPlaceService() {
        orderWagonPlaceDAO = new OrderWagonPlaceDao();
    }

    public boolean save(OrderWagonPlace entity) {
        orderWagonPlaceDAO.openCurrentSessionWithTransaction();
        orderWagonPlaceDAO.save(entity);
        orderWagonPlaceDAO.closeCurrentSessionWithTransaction();
        return true;
    }

    public boolean update(OrderWagonPlace entity) {
        orderWagonPlaceDAO.openCurrentSessionWithTransaction();
        orderWagonPlaceDAO.update(entity);
        orderWagonPlaceDAO.closeCurrentSessionWithTransaction();
        return true;
    }

    public boolean delete(OrderWagonPlace entity) {
        orderWagonPlaceDAO.openCurrentSessionWithTransaction();
        orderWagonPlaceDAO.delete(entity);
        orderWagonPlaceDAO.closeCurrentSessionWithTransaction();
        return true;
    }

    public List<OrderWagonPlace> findAll() {
        orderWagonPlaceDAO.openCurrentSession();
        List<OrderWagonPlace> resultList = orderWagonPlaceDAO.findAll();
        orderWagonPlaceDAO.closeCurrentSession();
        return resultList;
    }

    public List<OrderWagonPlace> findWhere(String s) {
        orderWagonPlaceDAO.openCurrentSession();
        List<OrderWagonPlace> resultList = orderWagonPlaceDAO.findWhere(s);
        orderWagonPlaceDAO.closeCurrentSession();
        return resultList;
    }

    public OrderWagonPlace findById(Integer id) {
        orderWagonPlaceDAO.openCurrentSession();
        OrderWagonPlace result = orderWagonPlaceDAO.findById(id);
        orderWagonPlaceDAO.closeCurrentSession();
        return result;
    }
}