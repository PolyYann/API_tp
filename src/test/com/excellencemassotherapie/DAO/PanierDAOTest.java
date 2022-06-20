package com.excellencemassotherapie.DAO;

import com.excellencemassotherapie.modele.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class PanierDAOTest {

    private static SoinDAO soinDAO = new SoinDAO();
    private static ProduitDAO produitDAO = new ProduitDAO();
    private static ClientDAO clientDAO = new ClientDAO();
    private static PanierDAO panierDAO = new PanierDAO();
    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        panierDAO.connect();

        clientDAO.connect();

    }
    @Test
    void getAll() {
    }

//    @Test
//    void testGetById(){
//        Panier panier = panierDAO.getById(3);
//        assertEquals(panier.getIdPanier(),3);
//        assertEquals(panier.getClient().getIdClient(),1);
//
//
//    }

    @Test
    void payerPanier() {
    }

//    @Test
//    void getByClientAndNonPaye() {
//        Panier panier = panierDAO.getByClientAndNonPaye(2);
//        assertEquals(panier.getIdPanier(),3);
//        assertEquals(panier.getClient().getIdClient(),2);
//        assertFalse(panier.isPaye());
//
//    }

    @Test
    void getByName() {
    }

//    @Test
//    void insert1() {
//     Panier panier = new Panier();
//     Client client = clientDAO.getById(2);
//        panier.setClient(client);
//    panierDAO.insert(panier);
//
//    }
}