package com.excellencemassotherapie.DAO;

import com.excellencemassotherapie.Mock.Mock;
import com.excellencemassotherapie.modele.Client;
import com.excellencemassotherapie.modele.Panier;
import com.excellencemassotherapie.modele.Produit;
import com.excellencemassotherapie.modele.Soin;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PanierDAOTest {
    private static List<Soin> soins =new ArrayList<>();
    private static List<Produit> produits =new ArrayList<>();
    private static List<Client> clients =new ArrayList<>();
    private PanierDAO panierDAO = new PanierDAO();
    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        soins = Mock.getSoins();
        produits = Mock.getProduits();
        clients = Mock.getClients();
    }
    @Test
    void getAll() {
    }

    @Test
    void testGetById(){

    }

    @Test
    void payerPanier() {
    }

    @Test
    void getByClientAndNonPaye() {
    }

    @Test
    void getByName() {
    }

//    @Test
//    void insert() {
//        panierDAO.connect();
//        Panier panier = new Panier();
//        panier.setListClients();
//
//
//    }
}