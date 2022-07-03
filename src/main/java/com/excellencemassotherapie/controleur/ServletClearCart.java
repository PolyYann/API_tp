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

        response.setContentType("text/html;charset=UTF-8");


        HttpSession session = request.getSession();
        List<Produit> listeProduits = (ArrayList)session.getAttribute("listProduits");
        List<Soin> listeSoins = (ArrayList)session.getAttribute("listeSoins");

        listeProduits.clear();
        listeSoins.clear();


        String url="/accueil.jsp";
        ServletContext sc = getServletContext();
        RequestDispatcher rd = sc.getRequestDispatcher(url);
        rd.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
