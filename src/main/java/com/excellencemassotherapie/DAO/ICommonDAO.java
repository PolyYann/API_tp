package com.excellencemassotherapie.DAO;

import java.util.List;

public interface ICommonDAO<T> {

    List<T> getAll();
    T getById(int id);
    T getByName(String nom);
    void insert(T t);

}
