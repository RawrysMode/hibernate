package com.rawrysmode.entities.client;

import java.util.List;

public class ClientService {
    private static ClientDao clientDAO;

    public ClientService() {
        clientDAO = new ClientDao();
    }

    public boolean save(Client entity) {
        clientDAO.openCurrentSessionWithTransaction();
        clientDAO.save(entity);
        clientDAO.closeCurrentSessionWithTransaction();
        return true;
    }

    public boolean update(Client entity) {
        clientDAO.openCurrentSessionWithTransaction();
        clientDAO.update(entity);
        clientDAO.closeCurrentSessionWithTransaction();
        return true;
    }

    public boolean delete(Client entity) {
        clientDAO.openCurrentSessionWithTransaction();
        clientDAO.delete(entity);
        clientDAO.closeCurrentSessionWithTransaction();
        return true;
    }

    public List<Client> findAll() {
        clientDAO.openCurrentSession();
        List<Client> resultList = clientDAO.findAll();
        clientDAO.closeCurrentSession();
        return resultList;
    }

    public List<Client> findWhere(String s) {
        clientDAO.openCurrentSession();
        List<Client> resultList = clientDAO.findWhere(s);
        clientDAO.closeCurrentSession();
        return resultList;
    }

    public Client findById(Integer id) {
        clientDAO.openCurrentSession();
        Client result = clientDAO.findById(id);
        clientDAO.closeCurrentSession();
        return result;
    }
}