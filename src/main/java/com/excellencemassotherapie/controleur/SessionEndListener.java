package com.excellencemassotherapie.controleur;

import com.excellencemassotherapie.DAO.LigneCommandDAO;
import com.excellencemassotherapie.DAO.PanierDAO;
import com.excellencemassotherapie.modele.Client;
import com.excellencemassotherapie.modele.LigneCommande;
import com.excellencemassotherapie.modele.Panier;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.util.List;

@WebListener
public class SessionEndListener implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {

    public SessionEndListener() {
    }




    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        LigneCommandDAO ligneCommandDAO = new LigneCommandDAO();
        PanierDAO panierDAO = new PanierDAO();
        Panier panier = (Panier) session.getAttribute("panierOut");
        List<LigneCommande> commandeProduitCours = (List) session.getAttribute("listLigneCommandeProduits");
        if (commandeProduitCours != null) {
            for (LigneCommande ligneCommande : commandeProduitCours) {
                ligneCommande.setPanier(panier);
                ligneCommandDAO.insert(ligneCommande);
            }
        }
        List<LigneCommande> commandeSoinCours = (List) session.getAttribute("listLigneCommandeSoins");
        if (commandeSoinCours != null) {
            for (LigneCommande ligneCommande : commandeSoinCours) {
                ligneCommande.setPanier(panier);
                ligneCommandDAO.insert(ligneCommande);
            }
        }
        Client client = (Client) session.getAttribute("client");

        panier.setClient(client);

            panierDAO.insert(panier);

    }


}
