package com.excellencemassotherapie.controleur;

import com.excellencemassotherapie.DAO.ClientDAO;
import com.excellencemassotherapie.DAO.LigneCommandDAO;
import com.excellencemassotherapie.DAO.PanierDAO;
import com.excellencemassotherapie.modele.Client;
import com.excellencemassotherapie.modele.LigneCommande;
import com.excellencemassotherapie.modele.Panier;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@WebServlet(name = "ServletConnection", value = "/ServletConnection")
public class ServletConnection extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        //récupérer la session asociée à la requête
        HttpSession session = request.getSession();
        LigneCommandDAO ligneCommandDAO = new LigneCommandDAO();
        PanierDAO panierDAO = new PanierDAO();
        List<Panier> listPaniers = panierDAO.getAll();


        String source = "";

        String destination = "";
        String mdpSaisi = request.getParameter("password");
        String action = (String) request.getAttribute("name");
        ClientDAO clientDAO = new ClientDAO();
        Client client = new Client();
        client.setNom(request.getParameter("nom"));
        Panier panierClientEnCours = new Panier();
        List<LigneCommande> allLignBd = ligneCommandDAO.getAll();
        List<LigneCommande> commandeEnCours = (ArrayList) session.getAttribute("listLigneCommande");

        if (Objects.equals(action, "connection")) {
            for (Panier panierBD : listPaniers) {
                if (panierBD.getClient().getNom().equals(client.getNom()) && !panierBD.isPaye()) {
                    panierClientEnCours = panierBD;
                    if (panierClientEnCours.getClient() != null) {
                        for (LigneCommande tmpLCBD : allLignBd) {
                            if (tmpLCBD.getPanier().getIdPanier() == panierClientEnCours.getIdPanier()) {
                                if (!commandeEnCours.contains(tmpLCBD)) {
                                    commandeEnCours.add(tmpLCBD);
                                } else {
                                    for (LigneCommande tmpLCEC : commandeEnCours) {
                                        if (tmpLCEC.getIdLigneCommande() == tmpLCBD.getIdLigneCommande()) {
                                            tmpLCEC.setQuantite(tmpLCEC.getQuantite() + tmpLCBD.getQuantite());
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (panierClientEnCours.getClient() != null && commandeEnCours != null) {
                for (LigneCommande ligneCommande : commandeEnCours) {
                    ligneCommande.setPanier(panierClientEnCours);
                }
            }
            session.setAttribute("listLigneCommande", commandeEnCours);
        }else if(Objects.equals(action, "enregistrer")){
            //todo creer nouveau panier
        }
        session.setAttribute("panier", panierClientEnCours);


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