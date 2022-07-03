package com.excellencemassotherapie.controleur;

import com.excellencemassotherapie.DAO.LigneCommandDAO;
import com.excellencemassotherapie.DAO.ProduitDAO;
import com.excellencemassotherapie.modele.LigneCommande;
import com.excellencemassotherapie.modele.Panier;
import com.excellencemassotherapie.modele.Produit;
import com.excellencemassotherapie.modele.Soin;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
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
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

@WebServlet(name = "ServletPanier", value = "/ServletPanier")
public class ServletPanier extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {

        /**
         * VENDREDI:
         * NOTE: ------------- pour afficher un panier, il faut afficher la liste des ligne de
         * commande dont le idPanier = panierEnCours.getIDpanier de la session
         * m'assure que les quantité get sont seulement celles de l'ajout
         * revalider toutes les méthodes du bas
         * intégrer soins
         */


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
         * Création des paniers et listLigneCommande s'ils ton null
         */
        if (panierEnCours == null) {
            panierEnCours = new Panier();
        }
        if (listLigneCommande == null) {
            listLigneCommande = new ArrayList<>();
        }

        // création des attributs que j'aurai besoin
        LigneCommandDAO ligneCommandeDAO = new LigneCommandDAO();
        LigneCommande ligneCommandeAAjouter=null;
        Produit produitAAjouter = new Produit();
        Soin soinAAjouter = new Soin();
        String idProd = request.getParameter("productId");
        String idSoin = request.getParameter("soinId");
        String quantiteProduit = request.getParameter("quantityProduit");
        String quantiteSoin = request.getParameter("quantitySoin");
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
            if(idSoin != null && quantiteSoin != null){
                idSoinAAjouter = Integer.parseInt(idSoin);
                quantiteSoinAAjouter = Integer.parseInt(quantiteSoin);
                soinAAjouter.setIdSoin(idSoinAAjouter);
                /**
                 * obtenir les détails de l'item à ajouter
                 */
                List<Soin> listSoins = (List<Soin>) session.getAttribute("listSoins");
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
            if(idSoinAAjouter != -1 || quantiteSoinAAjouter != -1){
                ligneCommandeAAjouter = new LigneCommande(soinAAjouter, quantiteSoinAAjouter, panierEnCours);
            }

            if(ligneCommandeAAjouter != null) {
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

            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            String result= "reponse Ajax";
            out.write(result);

            //suite à l'ajout ou à la suppression on doit RÉ-ATTACHER à la session
            //à la place de l'ancien
            session.setAttribute("panierOut", panierEnCours);
            session.setAttribute("listLigneCommande", listLigneCommande);


            //redirect vers l'affichage des produits pour continuer de magasiner
            String url = "/affichageProduitsServices.jsp";
            RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
            rd.forward(request, response);

        } else {

            /**
             * Récupération de l'action reçue avec la requête
             * n.b. pour savoir quoi faire (Ajout, supp, checkout)
             */
            String action = request.getParameter("action");


            /**
             * Si action = ADD - ajouer un item au panier
             */
            if (action.equals("ADD")) {

//todo: copier le code quand il va fonctionner pour ajouter les soins---------------------------------------------------------


                //Dans le cas du clic sur goCart
            } else if (action.equals("goCart")) {
                String url = "/panier.jsp";
                RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
                rd.forward(request, response);
            }

            //Dans le cas du clic sur Checkout
//        } else if (action.equals("checkout")) {
//            for (LigneCommande ligneCommTemp : listLigneCommande) {
//                ligneCommandeDAO.insert(ligneCommTemp);
//            }
//        }
        }

//    //on va calculer le prix total
//    double total = 0;
//        for(
//    int i = 0; i<listProduits.size();i++)
//
//    {
//        Produit uneCommandeDeProduit = (Produit) listProduits.get(i);
//        double prix = uneCommandeDeProduit.getPrix();
////                int quantite = uneCommandeDeProduit.getQuantite();
////                total += (prix * quantite);
//    }

////formulation bizarre - à comprendre------------------------------------------
//        //deviner à quoi cela sert ??????
//        total += 0.005;
//        String amount = new Double(total).toString();
//        int n = amount.indexOf('.');
//        amount = amount.substring(0, n + 3);
//        request.setAttribute("amount", amount);
//
//        //on redirige la requête vers la page de Checkout
//        String url = "/checkout.jsp";
//        ServletContext sc = getServletContext();
//        RequestDispatcher rd = sc.getRequestDispatcher(url);
//        rd.forward(request, response);
//    }


//------------------------------------------------------------------------------------------------------------------
//méthode utilitaire qui sert à récupérer les différentes
//parties d'un item choisi de la liste
// et retourne un objet de type Produit qui va être utlisé par la servlet
//    private Produit getItem(HttpServletRequest req) {
//
//        //on récupère l'item choisi par l'utilisateur dans la liste
//        String monItem = req.getParameter("typeItemChoisi");
//
//        //on récupère la quantité saisie
//        int quantite = Integer.parseInt(req.getParameter("quantite"));
//
//        // on récupère les différentes parties
//
//        String action = req.getParameter("action");
//        if (action.equals("ADD")){
//            //récupère l'index de l'item à ajouter
//            String idItemToAdd =
//        }
//
//
//        Produit itemToAdd = new Produit();
//        itemToAdd.setIdProduit(idItemToAdd);
//        StringTokenizer t = new StringTokenizer(monProduit, "|");
//        String tNom = t.nextToken();
//        String tDescription = t.nextToken();
//        String tQuantite = t.nextToken();
//        String tPrix = t.nextToken();
//        tPrix = tPrix.replace('$', ' ').trim();
//
//        //on crée un objet Produit avec les informations et on le retourne
//        // à la servlet
//        Produit produit = new Produit();
//        produit.setNom(tNom);
//        produit.setDescription(tDescription);
////        produit.setQuantite((new Integer(tQuantite)).intValue());
//        produit.setPrix((new Double(tPrix)).doubleValue());
//
//        return produit;
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

//    @Override
//    public String getServletInfo() {
//        return "Short description";
//    }// </editor-fold>

}





