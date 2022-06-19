package com.excellencemassotherapie.DAO;

import com.excellencemassotherapie.Mock.Mock;
import com.excellencemassotherapie.modele.Client;
import com.excellencemassotherapie.modele.Produit;
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

//    @Test
//    void getAll() {
//        clientDAO.connect();
//        List<Client> Compproduit = clientDAO.getAll();
//        for(int i =0; i<clients.size();i++){
//            assertEquals(clients.get(i).getNom(),Compproduit.get(i).getNom());
//            assertEquals(clients.get(i).getEmail(),Compproduit.get(i).getEmail());
//            assertEquals(clients.get(i).getPassword(),Compproduit.get(i).getPassword());
//            assertEquals(clients.get(i).getAdresse(),Compproduit.get(i).getAdresse());
//            assertEquals(clients.get(i).getTelephone(),Compproduit.get(i).getTelephone());
//    }}
//
//    @Test
//    void getById() {
//        clientDAO.connect();
//        Client CompClient = clientDAO.getById(3);
//        assertEquals(clients.get(2).getNom(),CompClient.getNom());
//        assertEquals(clients.get(2).getTelephone(),CompClient.getTelephone());
//        assertEquals(clients.get(2).getEmail(),CompClient.getEmail());
//        assertEquals(clients.get(2).getAdresse(),CompClient.getAdresse());
//        assertEquals(clients.get(2).getPassword(),CompClient.getPassword());
//    }
//
//    @Test
//    void getByName() {
//    clientDAO.connect();
//    Client CompClient = clientDAO.getByName("Yann Lebeau");
//    assertEquals(clients.get(2).getNom(),CompClient.getNom());
//    assertEquals(clients.get(2).getTelephone(),CompClient.getTelephone());
//    assertEquals(clients.get(2).getEmail(),CompClient.getEmail());
//    assertEquals(clients.get(2).getAdresse(),CompClient.getAdresse());
//    assertEquals(clients.get(2).getPassword(),CompClient.getPassword());
//    }

//    @Test
//    void insert() {
//        clientDAO.connect();
//        for(Client client: clients){
//            clientDAO.insert(client);
//        }
//        clientDAO.disconnect();
//    }
}