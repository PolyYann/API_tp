package com.excellencemassotherapie.DAO;

import com.excellencemassotherapie.modele.LigneCommande;
import com.excellencemassotherapie.modele.Panier;
import com.excellencemassotherapie.modele.Produit;
import com.excellencemassotherapie.modele.Soin;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LigneCommandDAOTest {
    private static LigneCommandDAO ligneCommandDAO = new LigneCommandDAO();
    private static PanierDAO panierDAO = new PanierDAO();
    private static ProduitDAO produitDAO = new ProduitDAO();
    private static SoinDAO soinDAO = new SoinDAO();

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        ligneCommandDAO.connect();
        panierDAO.connect();
        produitDAO.connect();
        soinDAO.connect();
    }

//    @Test
//    void getAll() {
//        List<LigneCommande> ligneCommandeList = ligneCommandDAO.getAll();
//        assertNotNull(ligneCommandeList);
//        assertEquals(ligneCommandeList.size(), 2);
//    }

    @Test
    void getById() {
    }

//    @Test
//    void insert() {
//        List<Produit> produits = produitDAO.getAll();
//        List<Soin> soins = soinDAO.getAll();
//        List<Panier> paniers = panierDAO.getAll();
//        LigneCommande ligneCommande = new LigneCommande(produits.get(10),3,paniers.get(2));
//
//        LigneCommande ligneCommande2 = new LigneCommande(soins.get(1),1,paniers.get(2));
//        ligneCommandDAO.insert(ligneCommande);
//        ligneCommandDAO.insert(ligneCommande2);
//    }

    @Test
    void modifieQuantite() {
    }
}