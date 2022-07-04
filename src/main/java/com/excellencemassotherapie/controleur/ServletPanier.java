package com.excellencemassotherapie.controleur;

import com.excellencemassotherapie.DAO.LigneCommandDAO;
import com.excellencemassotherapie.modele.LigneCommande;
import com.excellencemassotherapie.modele.Panier;
import com.excellencemassotherapie.modele.Produit;
import com.excellencemassotherapie.modele.Soin;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;



import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "ServletPanier", value = "/ServletPanier")
public class ServletPanier extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {


        /**
         * Récupération de la session de la requête
         */
        HttpSession session = request.getSession();
        if (session == null) {
            response.sendRedirect("http://localhost:82/error.html");
        }

        /**
         * Récupération de la liste des lignes de commandes
         * n.b. si aucune ligne de commande déjà en cours, l'objet retourné sera null
         */
        List<LigneCommande> listLigneCommande = (List<LigneCommande>) session.getAttribute("listLigneCommande");

        /**
         * Récupération du panier en cours
         * n.b. si aucun panier déjà en cours, l'objet retourné sera null
         */
        Panier panierEnCours = (Panier) session.getAttribute("panierOut");

        /**
         * Création des paniers et listLigneCommande s'ils sont null
         */
        if (panierEnCours == null) {
            panierEnCours = new Panier();
        }
        if (listLigneCommande == null) {
            listLigneCommande = new ArrayList<>();
        }

        // création des attributs requis dans le code de la servlet
        LigneCommandDAO ligneCommandeDAO = new LigneCommandDAO();
        LigneCommande ligneCommandeAAjouter = null;
        Produit produitAAjouter = new Produit();
        Soin soinAAjouter = new Soin();
//        String params = request.getParameter("params");
        String idProd = request.getParameter("productId");
        String idSoin = request.getParameter("treatmentId");
        String quantiteProduit = request.getParameter("quantityProduct");
        String quantiteSoin = request.getParameter("quantityTreatment");
        boolean ajax = "XMLHttpRequest".equals(request.getHeader("X-Requested-With"));

        if (ajax) {

            //booleen qui va être utilisé pour vérifier si l'item est déjà dans les lignes de commandes en cours
            boolean match = false;
            int idProduitAAjouter = -1, quantiteProduitAAjouter = -1;
            int idSoinAAjouter = -1, quantiteSoinAAjouter = -1;
            if (idProd != null && quantiteProduit != null) {
                idProduitAAjouter = Integer.parseInt(idProd);
                quantiteProduitAAjouter = Integer.parseInt(quantiteProduit);
                produitAAjouter.setIdProduit(idProduitAAjouter);

                /**
                 * obtenir les détails de l'item à ajouter
                 */
                List<Produit> listProduits = (List<Produit>) session.getAttribute("listProduits");
                for (Produit produit : listProduits) {
                    if (produit.getIdProduit() == idProduitAAjouter) {
                        produitAAjouter = produit;
                    }
                }
            }
            if (idSoin != null && quantiteSoin != null) {
                idSoinAAjouter = Integer.parseInt(idSoin);
                quantiteSoinAAjouter = Integer.parseInt(quantiteSoin);
                soinAAjouter.setIdSoin(idSoinAAjouter);
                /**
                 * obtenir les détails de l'item à ajouter
                 */
                List<Soin> listSoins = (List<Soin>) session.getAttribute("listeSoins");
                for (Soin soin : listSoins) {
                    if (soin.getIdSoin() == idSoinAAjouter) {
                        soinAAjouter = soin;
                    }
                }
            }

            /**
             * ajouter le Produit dans la ligne commande
             */
            if (idProduitAAjouter != -1 || quantiteProduitAAjouter != -1) {
                ligneCommandeAAjouter = new LigneCommande(produitAAjouter, quantiteProduitAAjouter, panierEnCours);
            }
            if (idSoinAAjouter != -1 || quantiteSoinAAjouter != -1) {
                ligneCommandeAAjouter = new LigneCommande(soinAAjouter, quantiteSoinAAjouter, panierEnCours);
            }

            if (ligneCommandeAAjouter != null) {
                //on vérifie si le produit est déjà dans le panier?
                //pour ne pas l'ajouter une autre fois
                for (int i = 0; i < listLigneCommande.size(); i++) {

                    //on récupère l'item à la position i
                    LigneCommande ligneCommandeExistante = listLigneCommande.get(i);

                    // si on trouve l'item dans la ligne de commande
                    if (ligneCommandeExistante.getProduit().getIdProduit() == ligneCommandeAAjouter.getProduit().getIdProduit()
                            || ligneCommandeExistante.getSoin().getIdSoin() == ligneCommandeAAjouter.getSoin().getIdSoin()) {

                        //on va modifier la quantité en lui ajoutantant la nouvelle quantité
                        ligneCommandeExistante.setQuantite(ligneCommandeExistante.getQuantite() + ligneCommandeAAjouter.getQuantite());

                        //on replace l'item dans la liste de ligne de commande
                        listLigneCommande.set(i, ligneCommandeAAjouter);

                        //on active la variable qui montre qu'on a trouvé l'item dans le panier
                        match = true;
                    }
                }
                //si match est à false, donc item non déjà dans la liste de ligne de commande
                //on va devoir l'ajouter
                if (!match) {
                    //on ajoute l'item à la liste de ligne de commande
                    listLigneCommande.add(ligneCommandeAAjouter);
                }
            }



            //suite à l'ajout ou à la suppression on doit RÉ-ATTACHER à la session
            //à la place de l'ancien
            session.setAttribute("panierOut", panierEnCours);
            session.setAttribute("listLigneCommande", listLigneCommande);


            //redirect vers l'affichage des produits pour continuer de magasiner
            String url = "/affichageProduitsServices.jsp";
            RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
            rd.forward(request, response);

        } else {
//----------------------------------------------------------------------------------------------
            /**
             * Récupération de l'action reçue avec la requête
             * n.b. pour savoir quoi faire (Go au panieer ou checkout)
             */
            String action = request.getParameter("action");

            //Si action = goCart (aller au panier)
            if (action.equals("goCart")) {

                String url = "/panier.jsp";
                RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
                rd.forward(request, response);

                //Si action = Checkout (payer)
            } else if (action.equals("checkout")) {

                /**
                 * Calculer le total de chaque ligne de commande et du panierTotal
                 */
                double totalLigneCommande = 0;
                double prixUnit = 0;
                double totalPanier = 0;

                for (LigneCommande ligneCommande : listLigneCommande) {

                    //si la ligne de commande est un produit
                    if (ligneCommande.getProduit() != null) {
                        prixUnit = ligneCommande.getProduit().getPrix();

                        // si la ligne de commande est un soin
                    } else {
                        prixUnit = ligneCommande.getSoin().getPrix();
                    }

                    int quantite = ligneCommande.getQuantite();
                    totalLigneCommande = (prixUnit * quantite);
                    totalPanier += totalLigneCommande;
                }
                session.setAttribute("totalPanier", totalPanier);


                //on redirige la requête vers la page de Checkout
                String url = "/panier.jsp"; //------------------------------pas certine que je peux passer un parametre ici
                RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
                rd.forward(request, response);
            }
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        processRequest(request, response);
    }


}





