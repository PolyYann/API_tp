package com.excellencemassotherapie.DAO;

import com.excellencemassotherapie.Mock.Mock;
import com.excellencemassotherapie.modele.Client;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClientDAOTest {
    private static List<Client> clients =new ArrayList<>();
    private ClientDAO clientDAO = new ClientDAO();
@BeforeAll
    static void setUpBeforeClass() throws Exception {
    clients = Mock.getClients();
    }

    @Test
    void getAll() {
    }

    @Test
    void getById() {
    }

    @Test
    void getByName() {
    }

//    @Test
//    void insert() {
//        clientDAO.connect();
//        for(Client client: clients){
//            clientDAO.insert(client);
//        }
//        clientDAO.disconnect();
//    }
}