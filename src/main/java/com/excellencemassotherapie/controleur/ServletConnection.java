package com.excellencemassotherapie.controleur;

import com.excellencemassotherapie.modele.Client;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServletConnection", value = "/ServletConnection")
public class ServletConnection extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String destination = "";
        String mdpSaisi = request.getParameter("password");

        if (mdpSaisi.equals("secret")) {
            destination ="/accueil.jsp";
        }else {
            destination ="/connection.jsp";
        }


        //récupérer la session asociée à la requête
        HttpSession session =request.getSession();
        String source = "";

        Client client =(Client) session.getAttribute("client");
        source = request.getParameter("source");
        if (source!=null)
        {
            //créer le bean avec les infos envoyées
            client = new Client();
            client.setNom(request.getParameter("nom"));
            client.setEmail(request.getParameter("telephone"));
            client.setEmail(request.getParameter("email"));
            client.setEmail(request.getParameter("adresse"));
            client.setEmail(request.getParameter("email"));

            //créer l'objet de session
            session.setAttribute("client", client);
            destination="/accueil.jsp";
        }

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(destination);
        dispatcher.forward(request, response);
    }


}
