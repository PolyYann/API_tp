package com.excellencemassotherapie.controleur;

import com.excellencemassotherapie.modele.Produit;
import com.excellencemassotherapie.modele.Soin;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

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
         * Récupération des 2 listes du panier
         * n.b. si aucun panier, l'objet retourné sera null
         */
        List<Produit> listeProduits = (ArrayList) session.getAttribute("panierProduit");
        List<Soin> listeSoins = (ArrayList) session.getAttribute("panierSoin");

        /**
         * Récupération de l'action reçue avec la requête
         * n.b. pour savoir quoi faire (Ajout, supp, checkout)
         */
        String action = request.getParameter("action");

        if (!action.equals("CHECKOUT")) {

            //si clic sur supprimer
            if (action.equals("DELETE")) {

                //on récupère l'indice de l'item à supprimer
                String del = request.getParameter("delindex");

                //on supprime l'item du panier
                int d = Integer.parseInt(del);
                listeProduits.remove(d);

                // si clic sur ajouter au panier
            } else if (action.equals("ADD")) {

                //booleen qui va être utilisé pour vérifier si l'item est déjà dans le panier
                boolean match = false;
                Produit produitAAjouter = getProduit(request);

                //si panier inexistant on va le créer(cas du 1er item à ajouter)
                if (listeProduits == null) {

                    //on crée le panier
                    listeProduits = new ArrayList();

                    //on ajoute le premier Produit
                    listeProduits.add(produitAAjouter);

                //si le panier existe déjà (listePanier non null)
                } else {

                    //on vérifie si le produit est déjà dans le panier?
                    //pour ne pas l'ajouter une autre fois
                    for (int i = 0; i < listeProduits.size(); i++) {

                        //on récupère l'item à la position i
                        Produit produitDejaDansPanier = (Produit) listeProduits.get(i);

                        // si on trouve l'item dans le panier
                        if (produitDejaDansPanier.getNom().equals(produitAAjouter.getNom())) {

                            //on va modifier la quantité en lui ajoutantant la
                            // nouvelle quantité
                            produitDejaDansPanier.setQuantite(produitDejaDansPanier.getQuantite() + produitAAjouter.getQuantite());

                            //on replace l'item dans le panier
                            listeProduits.set(i, produitDejaDansPanier);

                            //on active la variable qui montre qu'on a trouvé l'item
                            //dans le panier
                            match = true;
                        } //end of if name matches
                    } // end of for

                    //si match est à false, donc item non déjà dans le panier,
                    //on va devoir l'ajouter
                    if (!match)
                        //on ajoute l'item au panier
                        listeProduits.add(produitAAjouter);
                }
            }

            //suite à l'ajout ou à la suppression on doit RÉ-ATTACHER à la session
            //à la place de l'ancien
            session.setAttribute("panierProduit", listeProduits);


//Nous on ne veut pas faire ceci / voir à refaire ce bout de code----------------------------------------------------------
            //et on redirige la requête vers la page Accueil.jsp qui va afficher
            //le nouveau panier (grâce au INCLUDE)
            String url = "/EShop.jsp";
            ServletContext sc = getServletContext();
            RequestDispatcher rd = sc.getRequestDispatcher(url);
            rd.forward(request, response);

            //---------------------------------------------------------------modifier le total por inclure les données des soins-------------------
            //Dans le cas du clic sur Checkout
        } else if (action.equals("CHECKOUT")) {

            //on va calculer le prix total
            double total = 0;
            for (int i = 0; i < listeProduits.size(); i++) {
                Produit uneCommandeDeProduit = (Produit) listeProduits.get(i);
                double prix = uneCommandeDeProduit.getPrix();
                int quantite = uneCommandeDeProduit.getQuantite();
                total += (prix * quantite);
            }

//formulation bizarre - à comprendre------------------------------------------
            //deviner à quoi cela sert ??????
            total += 0.005;
            String amount = new Double(total).toString();
            int n = amount.indexOf('.');
            amount = amount.substring(0, n + 3);
            request.setAttribute("amount", amount);

            //on redirige la requête vers la page de Checkout
            String url = "/checkout.jsp";
            ServletContext sc = getServletContext();
            RequestDispatcher rd = sc.getRequestDispatcher(url);
            rd.forward(request, response);
        }

    }

    //méthode utilitaire qui sert à récupérer les différentes
    //parties d'un item (Produit)choisi de la liste (séparées par le |)
    // et retourne un objet de type Produit qui va être utlisé par la servlet
    private Produit getProduit(HttpServletRequest req) {
        //imagine if all this was in a scriptlet...ugly, eh?
        //on récupère l'item choisi par l'utilisateur dans la liste
        String monProduit = req.getParameter("Produit");

        //on récupère la quantité saisie
        String quantite = req.getParameter("quantite");

        // on récupère les différentes parties
        StringTokenizer t = new StringTokenizer(monProduit, "|");
        String tNom = t.nextToken();
        String tDescription = t.nextToken();
        String tQuantite = t.nextToken();
        String tPrix = t.nextToken();
        tPrix = tPrix.replace('$', ' ').trim();

        //on crée un objet Produit avec les informations et on le retourne
        // à la servlet
        Produit produit = new Produit();
        produit.setNom(tNom);
        produit.setDescription(tDescription);
        produit.setQuantite((new Integer(tQuantite)).intValue());
        produit.setPrix((new Double(tPrix)).doubleValue());

        return produit;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
