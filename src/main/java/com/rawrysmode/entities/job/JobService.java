package com.rawrysmode.entities.job;

import java.util.List;

public class JobService {

    private static JobDao jobDAO;

    public JobService() {
        jobDAO = new JobDao();
    }

    public boolean save(Job entity) {
        jobDAO.openCurrentSessionWithTransaction();
        jobDAO.save(entity);
        jobDAO.closeCurrentSessionWithTransaction();
        return true;
    }

    public void update(Job entity) {
        jobDAO.openCurrentSessionWithTransaction();
        jobDAO.update(entity);
        jobDAO.closeCurrentSessionWithTransaction();
    }

    public void delete(Job entity) {
        jobDAO.openCurrentSessionWithTransaction();
        jobDAO.delete(entity);
        jobDAO.closeCurrentSessionWithTransaction();
    }

    public List<Job> findAll() {
        jobDAO.openCurrentSession();
        List<Job> resultList = jobDAO.findAll();
        jobDAO.closeCurrentSession();
        return resultList;
    }

    public List<Job> findWhere(String s) {
        jobDAO.openCurrentSession();
        List<Job> resultList = jobDAO.findWhere(s);
        jobDAO.closeCurrentSession();
        return resultList;
    }

    public Job findById(Integer id) {
        jobDAO.openCurrentSession();
        Job result = jobDAO.findById(id);
        jobDAO.closeCurrentSession();
        return result;
    }

}