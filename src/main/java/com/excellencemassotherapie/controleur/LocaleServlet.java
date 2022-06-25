package com.excellencemassotherapie.controleur;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.Locale;

@WebServlet(name = "LocaleServlet", value = "/LocaleServlet")
public class LocaleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Locale localeReq = request.getLocale();

        request.setAttribute("langue", localeReq.getLanguage());
        RequestDispatcher dispatcher = request.getRequestDispatcher(("afficherLocaleRequete.jsp"));
        dispatcher.forward(request, response);

    }
}
