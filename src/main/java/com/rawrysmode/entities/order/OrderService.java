package com.rawrysmode.entities.order;

import java.util.List;

public class OrderService {

    private static OrderDao orderDAO;

    public OrderService() {
        orderDAO = new OrderDao();
    }

    public boolean save(Order entity) {
        orderDAO.openCurrentSessionWithTransaction();
        orderDAO.save(entity);
        orderDAO.closeCurrentSessionWithTransaction();
        return true;
    }

    public void update(Order entity) {
        orderDAO.openCurrentSessionWithTransaction();
        orderDAO.update(entity);
        orderDAO.closeCurrentSessionWithTransaction();
    }

    public void delete(Order entity) {
        orderDAO.openCurrentSessionWithTransaction();
        orderDAO.delete(entity);
        orderDAO.closeCurrentSessionWithTransaction();
    }

    public List<Order> findAll() {
        orderDAO.openCurrentSession();
        List<Order> resultList = orderDAO.findAll();
        orderDAO.closeCurrentSession();
        return resultList;
    }

    public List<Order> findWhere(String s) {
        orderDAO.openCurrentSession();
        List<Order> resultList = orderDAO.findWhere(s);
        orderDAO.closeCurrentSession();
        return resultList;
    }

    public Order findById(Integer id) {
        orderDAO.openCurrentSession();
        Order result = orderDAO.findById(id);
        orderDAO.closeCurrentSession();
        return result;
    }

}