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
//    @Test
//    void getAll() {
//        produitDAO.connect();
//        List<Produit> Compproduit = produitDAO.getAll();
//        for(int i =0; i<produits.size();i++){
//            assertEquals(produits.get(i).getNom(),Compproduit.get(i).getNom());
//            assertEquals(produits.get(i).getDescription(),Compproduit.get(i).getDescription());
//            assertEquals(produits.get(i).getUrlImage(),Compproduit.get(i).getUrlImage());
//            assertEquals(produits.get(i).getCategorie(),Compproduit.get(i).getCategorie());
//            assertEquals(produits.get(i).getPrix(),Compproduit.get(i).getPrix());
//        }
//    }
//    @Test
//    void testGetById(){
//        produitDAO.connect();
//        Produit Compproduit = produitDAO.getById(13);
//        assertEquals(produits.get(12).getNom(),Compproduit.getNom());
//        assertEquals(produits.get(12).getDescription(),Compproduit.getDescription());
//        assertEquals(produits.get(12).getUrlImage(),Compproduit.getUrlImage());
//        assertEquals(produits.get(12).getCategorie(),Compproduit.getCategorie());
//        assertEquals(produits.get(12).getPrix(),Compproduit.getPrix());
//    }

//    @Test
//    void insert() {
//        produitDAO.connect();
//        for(Produit produit: produits){
//            produitDAO.insert(produit);
//        }
//        produitDAO.disconnect();
//    }
}