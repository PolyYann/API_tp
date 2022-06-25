package com.excellencemassotherapie.controleur;

import com.excellencemassotherapie.DAO.*;
import com.excellencemassotherapie.modele.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebFilter(filterName = "Filterretriever")
public class Filterretriever implements Filter {
    ClientDAO clientDAO = new ClientDAO();
    ProduitDAO produitDAO = new ProduitDAO();
    ProfessionnelDAO professionnelDAO = new ProfessionnelDAO();
    LigneCommandDAO ligneCommandeDAO = new LigneCommandDAO();
    PanierDAO panierDAO = new PanierDAO();
    SoinDAO soinDAO = new SoinDAO();
    ServletContext ctx = null;
    public void init(FilterConfig config) throws ServletException {
            List<Client> clients = clientDAO.getAll();
            List<Produit> produits = produitDAO.getAll();
            List<Professionnel> professionnels = professionnelDAO.getAll();
            List<LigneCommande> ligneCommands = ligneCommandeDAO.getAll();
            List<Panier> paniers = panierDAO.getAll();
            List<Soin> soins = soinDAO.getAll();
            ctx = config.getServletContext();
            ctx.setAttribute("clients", clients);
            ctx.setAttribute("produits", produits);
            ctx.setAttribute("professionnels", professionnels);
            ctx.setAttribute("ligneCommands", ligneCommands);
            ctx.setAttribute("paniers", paniers);
            ctx.setAttribute("soins", soins);
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        chain.doFilter(request, response);
    }
}
