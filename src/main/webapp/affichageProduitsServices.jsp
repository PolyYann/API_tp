<%--
  Created by IntelliJ IDEA.
  User: Mélanie
  Date: 2022-06-19
  Time: 14:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Produit et services</title>
    <!-- Favicon-->
    <link rel="icon" type="image/x-icon" href="img/icon.jpg"/>
    <!--Bootstrap -->
    <link rel="stylesheet" href="css/style.css"/>
    <link rel="stylesheet" href="bootstrap/bootstrap-grid.min.css"/>
    <link rel="stylesheet" href="bootstrap/bootstrap-reboot.min.css"/>
    <link rel="stylesheet" href="bootstrap/bootstrap.min.css"/>
    <link rel="stylesheet" href="https://bootstrap-colors-extended.herokuapp.com/bootstrap-colors.css"/>

</head>
<body style="background-image: url('img/table.jpg');">

<form name="articleForm" action="ServletPanier" method="post">

    <h3 style="color:white;">Affichage de tous les produits</h3>
    <br>
    <br>
    <!--Voir dans mes favoris, pour insérer un navbar a gauche pour filtrer par produite / par soins / ou par type de produit (douleur/he, soinvisage------------------------------------------->
    <!--insérer ici un choose en fonction de plus de détail-------------------------------------------->
    <div class="row  text-secondary">
        <div class="col-3" text-left>
            <div class="card" style="width: 18rem;">
                <img src="img/1he/he_citron.jpg" class="card-img-top" alt="...">
                <div class="card-body">
                    <h5 class="card-title">Huile essentielle Citron</h5>
                    <p class="card-text">Longue description.</p>
                </div>
                <ul class="list-group list-group-flush">
                    <li class="list-group-item">bla</li>
                    <li class="list-group-item">bla</li>
                </ul>
                <div class="card-body">
                    <a href="#" class="card-link">

                        <!-- ICI on a la zone de texte pour saisir la quantité -->
                        Quantité:<input type="text" name="quantite" SIZE="3" value=1>

                        <!--Ici on a un champ caché qui est renvoyé au controleur avec les autres
                        données de la requête. Puisque la servlet controleur va traiter les autres
                        demandes: Supprimer un élément du panier, commander (Checkout), ce champ caché
                        va être lu par la servlet pour déterminer le traitement à exécuter
                        -->
                        <input type="hidden" name="action" value="ADD">
                    </a>
                    <a href="#" class="card-link">
                        <!-- en cliquant sur ce bouton, la requête est envoyée à la servlet -->
                        <input type="submit" name="Submit" value="Ajouter au panier">
                    </a>
                </div>
            </div>
        </div>

        <div class="col-3" text-left>
            <div class="card" style="width: 18rem;">
                <img src="img/1he/he_cypres.jpg" class="card-img-top" alt="...">
                <div class="card-body">
                    <h5 class="card-title">Huile essentielle Cypres</h5>
                    <p class="card-text">Longue description.</p>
                </div>
                <ul class="list-group list-group-flush">
                    <li class="list-group-item">bla</li>
                    <li class="list-group-item">bla</li>
                </ul>
                <div class="card-body">
                    <a href="#" class="card-link">

                        <!-- ICI on a la zone de texte pour saisir la quantité -->
                        Quantité:<input type="text" name="quantite" SIZE="3" value=1>

                        <!--Ici on a un champ caché qui est renvoyé au controleur avec les autres
                        données de la requête. Puisque la servlet controleur va traiter les autres
                        demandes: Supprimer un élément du panier, commander (Checkout), ce champ caché
                        va être lu par la servlet pour déterminer le traitement à exécuter
                        -->
                        <input type="hidden" name="action" value="ADD">
                    </a>
                    <a href="#" class="card-link">
                        <!-- en cliquant sur ce bouton, la requête est envoyée à la servlet -->
                        <input type="submit" name="Submit" value="Ajouter au panier">
                    </a>
                </div>
            </div>
        </div>


        <div class="col-3" text-left>
            <div class="card" style="width: 18rem;">
                <img src="img/1he/he_geranium.jpg" class="card-img-top" alt="...">
                <div class="card-body">
                    <h5 class="card-title">Huile essentielle Geranium</h5>
                    <p class="card-text">Longue description.</p>
                </div>
                <ul class="list-group list-group-flush">
                    <li class="list-group-item">bla</li>
                    <li class="list-group-item">bla</li>
                </ul>
                <div class="card-body">
                    <a href="#" class="card-link">

                        <!-- ICI on a la zone de texte pour saisir la quantité -->
                        Quantité:<input type="text" name="quantite" SIZE="3" value=1>

                        <!--Ici on a un champ caché qui est renvoyé au controleur avec les autres
                        données de la requête. Puisque la servlet controleur va traiter les autres
                        demandes: Supprimer un élément du panier, commander (Checkout), ce champ caché
                        va être lu par la servlet pour déterminer le traitement à exécuter
                        -->
                        <input type="hidden" name="action" value="ADD">
                    </a>
                    <a href="#" class="card-link">
                        <!-- en cliquant sur ce bouton, la requête est envoyée à la servlet -->
                        <input type="submit" name="Submit" value="Ajouter au panier">
                    </a>
                </div>
            </div>
        </div>


        <div class="col-3" text-left>
            <div class="card" style="width: 18rem;">
                <img src="img/1he/he_lavande.jpg" class="card-img-top" alt="...">
                <div class="card-body">
                    <h5 class="card-title">Huile essentielle Lavande</h5>
                    <p class="card-text">Longue description.</p>
                </div>
                <ul class="list-group list-group-flush">
                    <li class="list-group-item">bla</li>
                    <li class="list-group-item">bla</li>
                </ul>
                <div class="card-body">
                    <a href="#" class="card-link">

                        <!-- ICI on a la zone de texte pour saisir la quantité -->
                        Quantité:<input type="text" name="quantite" SIZE="3" value=1>

                        <!--Ici on a un champ caché qui est renvoyé au controleur avec les autres
                        données de la requête. Puisque la servlet controleur va traiter les autres
                        demandes: Supprimer un élément du panier, commander (Checkout), ce champ caché
                        va être lu par la servlet pour déterminer le traitement à exécuter
                        -->
                        <input type="hidden" name="action" value="ADD">
                    </a>
                    <a href="#" class="card-link">
                        <!-- en cliquant sur ce bouton, la requête est envoyée à la servlet -->
                        <input type="submit" name="Submit" value="Ajouter au panier">
                    </a>
                </div>
            </div>
        </div>

    </div>

</form>


<script src="${pageContext.request.contextPath}js/script.js"></script>
<script src="${pageContext.request.contextPath}bootstrap/bootstrap.bundle.min.js"></script>
<script src="${pageContext.request.contextPath}bootstrap/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}bootstrap/jquery-3.6.0.min.js"></script>
<script src="https://unpkg.com/@popperjs/core@2"></script>
</body>
</html>
