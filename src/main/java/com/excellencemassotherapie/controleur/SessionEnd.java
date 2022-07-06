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
public class SessionEnd implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {

    public SessionEnd() {
    }




    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        LigneCommandDAO ligneCommandDAO = new LigneCommandDAO();
        PanierDAO panierDAO = new PanierDAO();
        List<LigneCommande> commandeProduitCours = (List) session.getAttribute("listLigneCommandeProduits");
        if (commandeProduitCours != null) {
            for (LigneCommande ligneCommande : commandeProduitCours) {
                ligneCommandDAO.insert(ligneCommande);
            }
        }
        List<LigneCommande> commandeSoinCours = (List) session.getAttribute("listLigneCommandeSoins");
        if (commandeSoinCours != null) {
            for (LigneCommande ligneCommande : commandeSoinCours) {
                ligneCommandDAO.insert(ligneCommande);
            }
        }
        Client client = (Client) session.getAttribute("client");
        Panier panier = (Panier) session.getAttribute("panierOut");
        panier.setClient(client);
        if (panier != null) {
            panierDAO.insert(panier);
        }
    }


}
