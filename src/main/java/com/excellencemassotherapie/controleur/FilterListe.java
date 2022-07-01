package com.excellencemassotherapie.controleur;

import com.excellencemassotherapie.DAO.ProduitDAO;
import com.excellencemassotherapie.DAO.SoinDAO;
import com.excellencemassotherapie.modele.Produit;
import com.excellencemassotherapie.modele.Soin;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebFilter(filterName = "FilterListe", servletNames = {"ServletAffichage"})
public class FilterListe implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        SoinDAO soinDAO = new SoinDAO();
        List<Soin> listeSoins = soinDAO.getAll();
        List<Soin> listeSoinsFiltree = new ArrayList<>();

        request.setAttribute("listeSoins", listeSoins);
        ProduitDAO produitDAO = new ProduitDAO();
        List<Produit> listProduits = produitDAO.getAll();
        List<Produit> listProduitsFiltre = new ArrayList<>();
        String[] choix = request.getParameterValues("choix");
        String tousChoix = "";

       try {

            for (String s : choix) {
                tousChoix += (s);
            }

            for (Produit produit : listProduits) {
                if (tousChoix.contains("2")) {
                    if (produit.getCategorie() == 1) {
                        listProduitsFiltre.add(produit);
                    }
                }
                if (tousChoix.contains("3")) {

                    if (produit.getCategorie() == 2) {
                        listProduitsFiltre.add(produit);
                    }
                }
                if (tousChoix.contains("4")) {
                    if (produit.getCategorie() == 3) {
                        listProduitsFiltre.add(produit);
                    }

                }
            }
            for(Soin soin: listeSoins){
                if(tousChoix.contains("5")){
                    if(soin.getNom().contains("Massage")){
                        listeSoinsFiltree.add(soin);
                    }
                    listeSoinsFiltree.add(soin);
                }
                if(tousChoix.contains("6")){
                    if(soin.getNom().contains("taping")){
                        listeSoinsFiltree.add(soin);
                    }
                }

            }
        }catch (NullPointerException e){
           listeSoinsFiltree = listeSoins;
           listProduitsFiltre = listProduits;
        }


        request.setAttribute("listeSoins", listeSoinsFiltree);
        request.setAttribute("listProduits", listProduitsFiltre);

        chain.doFilter(request, response);
    }
}
