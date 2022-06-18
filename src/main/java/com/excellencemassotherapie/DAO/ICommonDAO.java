package com.excellencemassotherapie.DAO;

import java.util.List;

public interface ICommonDAO<T> {
    void connect();
    void disconnect();
    List<T> getAll();
    T getById(int id);
    T getByName(String nom);
    void insert(T t);

}
