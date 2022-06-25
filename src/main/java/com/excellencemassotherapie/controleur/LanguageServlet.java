package com.excellencemassotherapie.controleur;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "LanguageServlet", value = "/LanguageServlet")
public class LanguageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String langue = (String) request.getAttribute("langue");
        if(langue == null || request.getParameter("src").equals("1")) {
            String langueChoisie = request.getParameter("langue");
            session.setAttribute("langue", langueChoisie);
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("accueil.jsp");//pageResultat provient de la démo de I18N
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
