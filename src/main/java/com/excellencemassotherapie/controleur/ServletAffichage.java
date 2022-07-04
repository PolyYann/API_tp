package com.excellencemassotherapie.controleur;

import com.excellencemassotherapie.DAO.ProduitDAO;
import com.excellencemassotherapie.DAO.SoinDAO;
import com.excellencemassotherapie.modele.LigneCommande;
import com.excellencemassotherapie.modele.Produit;
import com.excellencemassotherapie.modele.Soin;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import javax.print.attribute.standard.PDLOverrideSupported;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@WebServlet(name = "ServletAffichage", value = "/ServletAffichage")


public class ServletAffichage extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ProduitDAO produitDAO = new ProduitDAO();
        SoinDAO soinDAO = new SoinDAO();
        List<Soin> listeSoins = soinDAO.getAll();
        List<Soin> listeSoinsFiltree = new ArrayList<>();

        List<Produit> listeProduits = produitDAO.getAll();
        List<Produit> listeProduitsFiltre = new ArrayList<>();
        String[] choix = request.getParameterValues("choix");
        String tousChoix = "";

        if (choix != null) {

            for (String s : choix) {
                tousChoix += (s);
            }

            for (Produit produit : listeProduits) {
                if (tousChoix.contains("2")) {
                    if (produit.getCategorie() == 1) {
                        listeProduitsFiltre.add(produit);
                    }
                }
                if (tousChoix.contains("3")) {
                    if (produit.getCategorie() == 2) {
                        listeProduitsFiltre.add(produit);
                    }
                }
                if (tousChoix.contains("4")) {
                    if (produit.getCategorie() == 3) {
                        listeProduitsFiltre.add(produit);
                    }
                }
            }
            for (Soin soin : listeSoins) {
                if (tousChoix.contains("5")) {
                    if (soin.getNom().toLowerCase(Locale.ROOT).contains("massage")) {
                        listeSoinsFiltree.add(soin);
                    }

                }
                if (tousChoix.contains("6")) {
                    if (soin.getNom().toLowerCase(Locale.ROOT).contains("taping")) {
                        listeSoinsFiltree.add(soin);
                    }
                }
            }
        } else {
            listeSoinsFiltree = listeSoins;
            listeProduitsFiltre = listeProduits;
        }

        session.setAttribute("listeSoins", listeSoinsFiltree);
        session.setAttribute("listeProduits", listeProduitsFiltre);
        RequestDispatcher dispatcher;

//if(action.equals("affichage")) {

        dispatcher = getServletContext().getRequestDispatcher("/affichageProduitsServices.jsp");
        dispatcher.forward(request, response);
        //     }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
