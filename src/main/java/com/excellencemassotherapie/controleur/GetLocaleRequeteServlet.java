package com.excellencemassotherapie.controleur;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.Locale;

@WebServlet(name = "LocaleServlet", value = "/LocaleServlet")
public class GetLocaleRequeteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String langue = (String) request.getAttribute("langue");
        if(langue == null || request.getParameter("src").equals("1")) {
            String langueChoisie = request.getParameter("langue");
            session.setAttribute("langue", langueChoisie);
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("pageResultat.jsp");//pageResultat provient de la démo de I18N
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
