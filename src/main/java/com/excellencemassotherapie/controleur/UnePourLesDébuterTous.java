package com.excellencemassotherapie.controleur;

import com.excellencemassotherapie.DAO.*;
import com.excellencemassotherapie.modele.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "UnePourLesControlesTous", value = "/UnePourLesControlesTous")
public class UnePourLesDébuterTous extends HttpServlet {

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        //instantiation des listes de tous les dao


        //récupere la session de la requete
        HttpSession session = request.getSession();
        if(session == null) {
            response.sendRedirect("http://localhost:8080/accueil.html");
        }




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
