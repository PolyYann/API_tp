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
        ClientDAO clientDAO = new ClientDAO();
        List<Panier> listPaniers = panierDAO.getAll();
        List<LigneCommande> allLignBd = ligneCommandDAO.getAll();
        List<Client> allClients = clientDAO.getAll();
        Panier panierClientEnCours = new Panier();

        String source = "";
        String destination = "";
        String mdpSaisi = request.getParameter("password");
        String action =  request.getParameter("send");

        Client client = new Client();
        client.setNom(request.getParameter("nom"));


        List<LigneCommande> commandeEnCours = (ArrayList) session.getAttribute("listLigneCommande");

        if (action.equals("signin")) {
            for(Client tmpClient: allClients){

                if(tmpClient.getNom().equals(client.getNom())){
                    if(tmpClient.getPassword().equals(mdpSaisi)){
                        client = tmpClient;
                    }
                    destination = "/accueil.jsp";
                }else{
                    destination= "/enregistrer.jsp?action=signup";
                }
            }
            for (Panier panierBD : listPaniers) {
                if (panierBD.getClient().getNom().equals(client.getNom()) && !panierBD.isPaye()) {
                    panierClientEnCours = panierBD;
                    if (panierClientEnCours.getClient() != null) { //si le client existe déjà dans la base de données
                        for (LigneCommande tmpLCBD : allLignBd) {
                            if (tmpLCBD.getPanier().getIdPanier() == panierClientEnCours.getIdPanier()) {//on récupère les lignes de commande en cours
                                if (!commandeEnCours.contains(tmpLCBD)) {//si ligne existe pas ajouter la ligne à la commande en cours
                                    commandeEnCours.add(tmpLCBD);
                                } else {
                                    for (LigneCommande tmpLCEC : commandeEnCours) { //si ligne existe et on ajuste quantité
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


        }else if(action.equals("signup")){
            client.setPassword(mdpSaisi);
            client.setTelephone(request.getParameter("telephone"));
            client.setEmail(request.getParameter("email"));
            client.setAdresse(request.getParameter("adresse"));
            List<Client> listClient = clientDAO.getAll();
            for (Client temp : listClient) {
                if (!temp.getNom().equals(client.getNom())) {
                     clientDAO.insert(client);
                }
            }
            destination = "/accueil.jsp";
        }

        //créer l'objet de session
        session.setAttribute("client", client);
        session.setAttribute("listLigneCommande", commandeEnCours);
        session.setAttribute("panierOut", panierClientEnCours);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(destination);
        dispatcher.forward(request, response);
    }
}