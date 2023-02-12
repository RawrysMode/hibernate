package com.rawrysmode.entities;

import java.util.List;

public interface Dao<T> {
    List<T> findAll();

    List<T> findWhere(String s);

    T findById(Integer id);

    boolean save(T entity);

    boolean update(T entity);

    boolean delete(T entity);
}
