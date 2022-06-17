package com.excellencemassotherapie.DAO;

import com.excellencemassotherapie.modele.Produit;

import java.util.List;

public interface CommonDAO<T> {
    void connect();
    void disconnect();
    List<T> getAll();
    T getById(int id);
    T getByName(String nom);
    void insert(T t);

}
