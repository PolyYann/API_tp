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

        //récupérer la session asociée à la requête
        HttpSession session =request.getSession();
        String source = "";

        Client client = (Client) session.getAttribute("info");
        source = request.getParameter("source");
        if (source != null)
        {
            //créer le bean avec les infos envoyées
            client = new Client();
            client.setNom(request.getParameter("nom"));
            client.setAdresse(request.getParameter("adresse"));
            client.setEmail(request.getParameter("email"));
            client.setTelephone(request.getParameter("telephone"));
            client.setPassword(request.getParameter("password"));

            //créer l'objet de session
            session.setAttribute("client", client);
            destination="accueil.jsp";
        }
        else if (client == null)
        {
            destination ="/connection.jsp";
        }
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(destination);
        dispatcher.forward(request, response);
    }
}
