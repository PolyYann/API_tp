package com.excellencemassotherapie.controleur;

import com.excellencemassotherapie.modele.Produit;
import com.excellencemassotherapie.modele.Soin;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ServletClearCart", value = "/ServletClearCart")
public class ServletClearCart extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");


        HttpSession session = request.getSession();

        if (session == null) {
            response.sendRedirect("http://localhost:82/error.html");
        } else {
            session.invalidate();
        }

        String url = "/accueil.jsp";

        RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
        rd.forward(request, response);
    }
}
