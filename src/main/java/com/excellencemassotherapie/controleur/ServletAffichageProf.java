package com.excellencemassotherapie.controleur;

import com.excellencemassotherapie.DAO.ProduitDAO;
import com.excellencemassotherapie.DAO.ProfessionnelDAO;
import com.excellencemassotherapie.DAO.SoinDAO;
import com.excellencemassotherapie.modele.Produit;
import com.excellencemassotherapie.modele.Professionnel;
import com.excellencemassotherapie.modele.Soin;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ServletAffichageProf", value = "/ServletAffichageProf")
public class ServletAffichageProf extends HttpServlet {

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //récupere la session de la requete
        HttpSession session = request.getSession();
        if (session == null) {
            response.sendRedirect("http://localhost:8080/accueil.html");
        }


        ProfessionnelDAO profDAO = new ProfessionnelDAO();

        List<Professionnel> listeProfs = profDAO.getAll();

        session.setAttribute("listeProfs", listeProfs);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/afficherProfessionnels.jsp");
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
