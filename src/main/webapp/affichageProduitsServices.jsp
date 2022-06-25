<%--
  Created by IntelliJ IDEA.
  User: Mélanie
  Date: 2022-06-19
  Time: 14:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <c:set var="loc" value="fr"/>   <!-- Ici, la valeur fr_FR est codé en dure, comme une valeur par défaut -->

    <fmt:setBundle basename="app" /><!-- basename=app ça veut dire que le fichier commence par app.-->
    <!--on met un if pour voir si on change de langue-->

    <c:if test="${!(empty param.locale)}"> <!-- param car on a pas de servet ici / sinon, on aurait pu mettre sessionScope et prendre les infos de la langue provenant de la page html -->
        <c:set var="loc" value="${param.locale}"/>
    </c:if>

    <fmt:setLocale value="${loc}"/> <!-- balise fmt:setLocale mentionne qu'on veut les infos contenues dans la value local (loc) -->


    <title><fmt:message key="excellence"/></title>
    <!-- Favicon-->
    <link rel="icon" type="image/x-icon" href="img/icon.jpg"/>
    <!--Bootstrap -->
    <link rel="stylesheet" href="css/style.css"/>
    <link rel="stylesheet" href="bootstrap/bootstrap-grid.min.css"/>
    <link rel="stylesheet" href="bootstrap/bootstrap-reboot.min.css"/>
    <link rel="stylesheet" href="bootstrap/bootstrap.min.css"/>
    <link rel="stylesheet" href="https://bootstrap-colors-extended.herokuapp.com/bootstrap-colors.css"/>

</head>
<body>

<div >
      <form name="articleForm" action="ServletPanier" method="post">
        <jsp:include page="navBar.jsp"/>
        <br>
        <h3 style="color:white;">Affichage de tous les produits</h3>
        <br>
        <br>

        <div class="container-fluid">
            <div class="row">
                <div class="col-3">
                    <div>
                        <jsp:include page="filter.jsp"/>
                    </div>
                </div>
                <div class="col-9">

                    <!---------------------------------------------------Début de la boucle pour affichage----------------------------------------------------->
                    <div class="row">
                    <c:forEach var="produit" varStatus="status" items="${requestScope.listProduits}" step="1" begin="0">

                        <div class="col-3 text-left">
                            <div class="card" style="width: 18rem;">
                                <img src="${produit.urlImage}" alt="${produit.nom}" class="card-img-top">
                                <div class="card-body">
                                    <h5 class="card-title">${produit.nom}</h5>
                                    <p class="card-text">${produit.description}</p>
                                </div>
                                <ul class="list-group list-group-flush">
                                    <li class="list-group-item">${produit.prix}</li>
                                </ul>
                                <div class="card-footer">
                                    <a href="#" class="card-link">

                                        <!-- ICI on a la zone de texte pour saisir la quantité -->
                                        <fmt:message key="quantity"/>:<input type="text"
                                                                             name="quantite"
                                                                             SIZE="3" value=1>

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

                    </c:forEach>
                    </div>
                    <!---------------------------------------------------fin de affichage----------------------------------------------------->
                </div>
            </div>
        </div>
    </form>
</div>

<script src="js/script.js"></script>
<script src="bootstrap/bootstrap.bundle.min.js"></script>
<script src="bootstrap/bootstrap.min.js"></script>
<script src="bootstrap/jquery-3.6.0.min.js"></script>
<script src="https://unpkg.com/@popperjs/core@2"></script>
</body>
</html>
