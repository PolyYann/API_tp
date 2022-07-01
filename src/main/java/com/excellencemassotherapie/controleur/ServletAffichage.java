package com.excellencemassotherapie.controleur;

import com.excellencemassotherapie.DAO.ProduitDAO;
import com.excellencemassotherapie.DAO.SoinDAO;
import com.excellencemassotherapie.modele.Produit;
import com.excellencemassotherapie.modele.Soin;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import javax.print.attribute.standard.PDLOverrideSupported;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ServletAffichage", value = "/ServletAffichage")


public class ServletAffichage extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<Soin> listeSoins= (List<Soin>)request.getAttribute("listeSoins");
        session.setAttribute("listeSoins", listeSoins);
        List<Produit> listProduits = (List<Produit>)request.getAttribute("listProduits");
        session.setAttribute("listProduits", listProduits);




        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/affichageProduitsServices.jsp");
        dispatcher.forward(request, response);

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
