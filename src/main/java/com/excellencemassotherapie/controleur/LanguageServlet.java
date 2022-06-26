package com.excellencemassotherapie.controleur;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.Locale;

@WebServlet(name = "LanguageServlet", value = "/LanguageServlet")
public class LanguageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String langue = (String) request.getAttribute("langue");
        String langueChoisie = "";

        if (langue == null ) {
            langueChoisie = request.getParameter("langue");
        } else if (langue == "Anglais") {
            langueChoisie = "en";
        } else if (langue == "French") {
            langueChoisie = "fr";
        }
        session.setAttribute("langue", langueChoisie);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("accueil.jsp");//pageResultat provient de la démo de I18N
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
