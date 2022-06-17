package com.excellencemassotherapie.DAO;

public interface CommonDAO {
    void connect();
    void disconnect();
    void getAll();
    void getById();
    void getByName();
    void insert();

}
