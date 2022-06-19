package com.excellencemassotherapie.DAO;

import com.excellencemassotherapie.Mock.Mock;
import com.excellencemassotherapie.modele.Produit;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProduitDAOTest {
    private static List<Produit> produits =new ArrayList<>();
    private ProduitDAO produitDAO = new ProduitDAO();
    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        produits = Mock.getProduits();
    }
    @Test
    void getAll() {
    }

//    @Test
//    void insert() {
//        produitDAO.connect();
//        for(Produit produit: produits){
//            produitDAO.insert(produit);
//        }
//        produitDAO.disconnect();
//    }
}