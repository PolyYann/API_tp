package com.excellencemassotherapie.controleur;

import com.excellencemassotherapie.DAO.ClientDAO;
import com.excellencemassotherapie.modele.Client;
import com.excellencemassotherapie.modele.Produit;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletConnection", value = "/ServletConnection")
public class ServletConnection extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        //récupérer la session asociée à la requête
        HttpSession session = request.getSession();
        String source = "";

        String destination = "";
        String mdpSaisi = request.getParameter("password");
        String action = (String) request.getAttribute("name");
        ClientDAO clientDAO = new ClientDAO();
        Client client = new Client();
        client.setNom(request.getParameter("nom"));


//        if (action == "signin") {
//
//            if (mdpSaisi.equals("secret")) {
//                destination = "/accueil.jsp";
//            } else {
//                destination = "/connection.jsp";
//            }
//        } else if (action == "signup") {

        //créer le client avec les infos passées du formulaire
        client.setPassword(mdpSaisi);
        client.setTelephone(request.getParameter("telephone"));
        client.setEmail(request.getParameter("email"));
        client.setAdresse(request.getParameter("adresse"));

        List<Client> listClient = clientDAO.getAll();
        for (Client temp : listClient) {
            if (!temp.getNom().equals(client.getNom())) {
                // clientDAO.insert(client);
            }
        }

        //créer l'objet de session
        session.setAttribute("client", client);
        destination = "/accueil.jsp";


        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(destination);
        dispatcher.forward(request, response);
    }
}