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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //récupérer la session asociée à la requête
        HttpSession session = request.getSession();
        LigneCommandDAO ligneCommandDAO = new LigneCommandDAO();
        PanierDAO panierDAO = new PanierDAO();
        ClientDAO clientDAO = new ClientDAO();
        List<Panier> listPaniers = panierDAO.getAll();
        List<LigneCommande> allLignBd = ligneCommandDAO.getAll();
        List<Client> allClients = clientDAO.getAll();
        Panier panierClientEnCours = new Panier();

        String destination = "";
        String mdpSaisi = request.getParameter("password");
        String action = request.getParameter("send");

        Client client = new Client();
        client.setNom(request.getParameter("nom"));
        client.setPassword(mdpSaisi);
        client.setTelephone(request.getParameter("phone"));
        client.setEmail(request.getParameter("email"));
        client.setAdresse(request.getParameter("address"));

        List<LigneCommande> commandeProduitsEnCours = (List) session.getAttribute("listLigneCommandeProduits");
        List<LigneCommande> commandeSoinsEnCours = (List) session.getAttribute("listLigneCommandeSoins");

        /**
         * Pour se connecter ou s'enregistrer
         */
        //pour se connecter
        if (action.equals("signin")) {
            //Valide si le client est bien dans la BD
            for (Client clientTemp : allClients) {

                if (clientTemp.getNom().equals(client.getNom()) && clientTemp.getPassword().equals(mdpSaisi)) {
                    client = clientTemp;
                    destination = "/accueil.jsp";
                } else {
                    //n'est pas dans la BD
                    destination = "/connection.jsp?action=signup";
                }
            }
            /**
             * verifie si le client existant a déjà un panier enregistré qui est aussi impayé
             */
            for (Panier panierBD : listPaniers) { // pour tous les paniers de la BD
                if (panierClientEnCours.getClient() != null) { // s'il y a un client relié au panier en cours
                    if (panierBD.getClient().getNom().equals(client.getNom()) && !panierBD.isPaye()) { // on vérifie si le client du panier en cours a aussu un panie dans la BD qui n'est pas payé
                        panierClientEnCours = panierBD;  // si le client a un panier dans la BD qui est impayé, on défini le panierEncours comme étant celui de la BD

                        //Analyser si les lignes de commandes de la BD ont le ID du Panier en cours
                        for (LigneCommande tempLCBD : allLignBd) { // toutes les lignes de commande de la BD
                            if (tempLCBD.getPanier().getIdPanier() == panierClientEnCours.getIdPanier()) {// si le IDpanier des lignes de commandes de la BD ont le même ID que le panier en cours
                                if (tempLCBD.getProduit() != null) { // Les lignes deveut dire que c'est un produit
                                    if (commandeProduitsEnCours.contains(tempLCBD)) {//si ligne existe déjà dans le panier,
                                        for (LigneCommande tempLCEC : commandeProduitsEnCours) { //si ligne existe on ajuste quantité
                                            if (tempLCEC.getProduit().getIdProduit() == tempLCBD.getProduit().getIdProduit()) {
                                                tempLCEC.setQuantite(tempLCEC.getQuantite() + tempLCBD.getQuantite());
                                                //set le panier dans la ligne de commande
                                                tempLCEC.setPanier(panierClientEnCours);

                                            }
                                        }
                                    } else { // si ligne commande Produit n'existe pas, on l'ajoute à la commande de produit
                                        commandeProduitsEnCours.add(tempLCBD);
                                    }
                                } else { //ligne de commande en cours.get produit est null donc, c'est un soin
                                    if (commandeSoinsEnCours.contains(tempLCBD)) {//si ligne existe déjà dans le panier,
                                        for (LigneCommande tempLCEC : commandeSoinsEnCours) { //si ligne existe on ajuste quantité
                                            if (tempLCEC.getSoin().getIdSoin() == tempLCBD.getSoin().getIdSoin()) {
                                                tempLCEC.setQuantite(tempLCEC.getQuantite() + tempLCBD.getQuantite());
                                                //set le panier dans la ligne de commande
                                                tempLCEC.setPanier(panierClientEnCours);

                                            }
                                        }
                                    } else { // si ligne commande Soin n'existe pas, on l'ajoute
                                        commandeSoinsEnCours.add(tempLCBD);
                                    }
                                }
                            }
                        }//fin de l'analyse de toutes les lignes de commandes de la BD
                    }
                }
            }//fin de l'analyse de tous les paniers de la BD
            //Fin du signin, on retourne a l'accueil
            destination = "/accueil.jsp";
        }//fin de la connection

        //pour s'enregistrer
        else if (action.contains("signup")) {

            List<Client> listClientAll = clientDAO.getAll();

            //tant que e flag est false, le client est déjà dans la BD
            boolean flag = false;
            for (Client temp : listClientAll) { //tous les clients de la BD
                if (temp.getNom().equals(client.getNom())) { //si le nouveau client = a un client de la BD, client déjà existant et flag = true
                    flag = true;
                    break;
                }
            }
            //si absent de la BD: flag reste false
            if (!flag) { // si flag = false: on ajoute le cliet à la BD
                clientDAO.insert(client);
            }
            //et on retourne à L'accueil
            destination = "/accueil.jsp";
        }

        //créer les objets de session
        session.setAttribute("client", client);

        session.setAttribute("listLigneCommandeProduits", commandeProduitsEnCours);
        session.setAttribute("listLigneCommandeSoins", commandeSoinsEnCours);
        session.setAttribute("panierOut", panierClientEnCours);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(destination);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        processRequest(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        processRequest(request, response);
    }
}