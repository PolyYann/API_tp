package com.excellencemassotherapie.controleur;

import com.excellencemassotherapie.DAO.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.util.List;

@WebListener
public class Listener implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {

    ClientDAO clientDAO = new ClientDAO();
    ProduitDAO produitDAO = new ProduitDAO();
    ProfessionnelDAO professionnelDAO = new ProfessionnelDAO();
    LigneCommandDAO ligneCommandeDAO = new LigneCommandDAO();
    PanierDAO panierDAO = new PanierDAO();
    SoinDAO soinDAO = new SoinDAO();

    public Listener() {
    }


    @Override
    public void contextInitialized(ServletContextEvent sce) {
        clientDAO.connect();
        ligneCommandeDAO.connect();
        produitDAO.connect();
        panierDAO.connect();
        professionnelDAO.connect();
        soinDAO.connect();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        clientDAO.disconnect();
        ligneCommandeDAO.disconnect();
        produitDAO.disconnect();
        panierDAO.disconnect();
        professionnelDAO.disconnect();
        soinDAO.disconnect();
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        /* Session is created. */
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {

    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent sbe) {
        /* This method is called when an attribute is added to a session. */
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent sbe) {
        /* This method is called when an attribute is removed from a session. */
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent sbe) {
        /* This method is called when an attribute is replaced in a session. */
    }
}
