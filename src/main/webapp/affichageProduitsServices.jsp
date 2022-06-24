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
<body >
<div class="bg-steel-light">
<form name="articleForm" action="ServletPanier" method="post">
    <jsp:include page="navBar.jsp"  />
    <br>
    <h3 style="color:white;">Affichage de tous les produits</h3>
    <br>
    <br>

    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12">

                <button type="button" class="btn btn-outline-info btn-sm">
                    Button
                </button>
                <div class="row">
                    <div class="col-md-3">
                        <ul class="nav flex-column nav-tabs">
                            <li class="nav-item">
                                <a class="nav-link active" href="#">Home</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">Profile</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link disabled" href="#">Messages</a>
                            </li>
                            <li class="nav-item dropdown ml-md-auto">
                                <a class="nav-link dropdown-toggle" href="http://example.com" id="navbarDropdownMenuLink" data-toggle="dropdown">Dropdown link</a>
                                <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownMenuLink">
                                    <a class="dropdown-item" href="#">Action</a> <a class="dropdown-item" href="#">Another action</a> <a class="dropdown-item" href="#">Something else here</a>
                                    <div class="dropdown-divider">
                                    </div> <a class="dropdown-item" href="#">Separated link</a>
                                </div>
                            </li>
                        </ul>
                    </div>
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
                            <div class="card-footer">
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
                            <div class="card-footer">
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
                            <div class="card-footer">
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
            </div>
        </div>
    </div>




</form>

</div>
<script src="${pageContext.request.contextPath}js/script.js"></script>
<script src="${pageContext.request.contextPath}bootstrap/bootstrap.bundle.min.js"></script>
<script src="${pageContext.request.contextPath}bootstrap/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}bootstrap/jquery-3.6.0.min.js"></script>
<script src="https://unpkg.com/@popperjs/core@2"></script>
</body>
</html>
