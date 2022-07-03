<%--
  Created by IntelliJ IDEA.
  User: Mélanie
  Date: 2022-06-19
  Time: 14:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <fmt:setLocale value="${sessionScope.langue}" scope="session"/>
    <!-- balise fmt :setLocale mentionne qu'on veut les infos contenues dans la value local (loc) -->

    <fmt:setBundle basename="app"/><!-- basename=app ça veut dire que le fichier commence par app.-->

    <title><fmt:message key="excellence"/></title>
    <!-- Favicon-->
    <link rel="icon" type="image/x-icon" href="img/icon.jpg"/>
    <!--Bootstrap -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <link rel="stylesheet" href="css/style.css"/>
    <link rel="stylesheet" href="css/bootstrap-grid.min.css"/>
    <link rel="stylesheet" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" href="https://bootstrap-colors-extended.herokuapp.com/bootstrap-colors.css"/>

</head>
<body>
<div class="row">

    <div class="bg-steel-light">
        <div>
            <jsp:include page="navBar.jsp"/>

            <br>
            <br>
            <br>
            <br>

            <div class="container-fluid">

                <div class="row">

                    <div class="col-3">
                        <form name="filtre" method="post" action="ServletAffichage">
                            <div class="card">
                                <header class="card-header">
                                    <i class="icon-control fa fa-chevron-down"></i>
                                    <h5 class="title ps-5"><fmt:message key="products_services"/></h5>
                                </header>

                                <div class="card-body">

                                    <div class="input-group">

                                        <div>
                                            <label>
                                                <input type="text" class="form-control"
                                                       placeholder="<fmt:message key="search"/>">
                                            </label>
                                        </div>
                                        <div class="input-group-append ps-2">
                                            <button class="btn btn-light" type="button">
                                                <i class="fa fa-search"><fmt:message key="search"/></i>
                                            </button>
                                        </div>


                                        <div class="card-body">
                                            <div class="row-col-12">
                                                <div class="row radio-btns">
                                                    <div class="col-6"><%--produit ou service--%>
                                                        <h5><label for="productChoix">

                                                        </label><input type="radio" checked="" id="productChoix"
                                                                       name="typeChoix" value="0">
                                                            <fmt:message key="product"/></h5>
                                                    </div>
                                                    <div class="col-6">
                                                        <h5><label for="treatmentChoix"></label>
                                                            <input type="radio" name="typeChoix" id="treatmentChoix"
                                                                   value="1">
                                                            <fmt:message
                                                                    key="treatment"/></h5>
                                                    </div>

                                                </div>
                                                <div class="row">
                                                    <div class="col-6" id="productChild">
                                                        <div class="row-cols-12">
                                                            <label class="control checkbox">
                                                                <input type="checkbox" name="choix" id="he" checked=""
                                                                       class="form-check-input " value="2">
                                                                <fmt:message key="essentialOil"/></label>

                                                        </div>
                                                        <div class="row-cols-12">
                                                            <label class="control checkbox">
                                                                <input type="checkbox" name="choix" id="skin" checked=""
                                                                       class="form-check-input choix" value="3">
                                                                <fmt:message key="skinCare"/> </label>

                                                        </div>
                                                        <div class="row-cols-12">
                                                            <label class="control checkbox">
                                                                <input type="checkbox" name="choix" id="analgesic"
                                                                       class="form-check-input " value="4" checked="">
                                                                <fmt:message key="analgesic"/> </label>

                                                        </div>
                                                    </div>
                                                    <div class="col-6" id="treatmentChild">
                                                        <div class="row-cols-12">

                                                            <label class="control checkbox">
                                                                <input type="checkbox" id="massage" name="choix"
                                                                       disabled=""
                                                                       class="form-check-input" value="5">
                                                                <fmt:message key="massage"/>
                                                            </label>
                                                        </div>
                                                        <div class="row-cols-12">
                                                            <label class="form-check-label">
                                                                <input type="checkbox" id="taping" name="choix"
                                                                       disabled=""
                                                                       class="form-check-input" value="6">
                                                                <fmt:message key="taping"/>
                                                            </label>
                                                        </div>

                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                </div>
                                <!-- card-body.// -->
                                <div class="card">
                                    <header class="card-header">
                                        <h5 class="title ps-5"><fmt:message key="pricerange"/></h5>
                                    </header>
                                    <div class="card-body ps-5">
                                        <label>0 $</label>
                                        <label for="slider" class="form-label">
                                            <input type="range" value="200" class="range"
                                                   id="slider"
                                                   max="200"
                                                   onchange="sliding()">
                                        </label>
                                        <label>200 $</label>

                                        <h5 id="sliderValue"></h5>
                                        <input type=submit value="<fmt:message key="apply"/>">

                                    </div>
                                </div>

                            </div>
                        </form>
                    </div>

                    <div class="col-9" >


                        <!---------------------------------------------------Début de la boucle pour affichage----------------------------------------------------->

                        <form name="articleForm" action="ServletPanier"  method="post">

                            <div class="row" id="productAffiche">
                                <c:forEach var="ProduitChoisi" varStatus="loop" items="${sessionScope.listProduits}"
                                           step="1" begin="0">

                                    <div class="col-3 text-left hidden" data-id="${ProduitChoisi.categorie}"
                                         id="pC${ProduitChoisi.idProduit}">
                                        <input type="hidden" value="${ProduitChoisi.categorie}">
                                        <div class="card ">
                                            <img src="${ProduitChoisi.urlImage}" alt="${ProduitChoisi.nom}"
                                                 class="card-img-top">
                                            <div class="card-body">
                                                <h5 class="card-title">${ProduitChoisi.nom}</h5>
                                                <p class="card-text">${ProduitChoisi.description}</p>
                                            </div>
                                            <ul class="list-group list-group-flush">
                                                <li class="list-group-item">${ProduitChoisi.prix}</li>
                                            </ul>
                                            <div class="card-footer">
                                                <a href="#" class="card-link">

                                                    <!-- ICI on a la zone de texte pour saisir la quantité -->
                                                    <fmt:message key="quantity"/>:<label>
                                                    <input type="text" name="quantite"
                                                           SIZE="3" value=1 id="idItem${ProduitChoisi.idProduit}">
                                                    </label>
                                                    <!--Ici on a un champ caché qui est renvoyé au controleur avec les autres
                                                    données de la requête. ce champ caché va être lu par la servlet pour déterminer
                                                     le traitement à exécuter
                                                    -->
                                                </a>
                                                <a href="#" class="card-link">
                                                    <input type="hidden" name="action" value="ADD">
                                                    <!-- en cliquant sur ce bouton, la requête est envoyée à la servlet -->
                                                    <input type="submit" name="Submit" value="<fmt:message key="addtocart"/>" >
                                                </a>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>

                            </div>
                            <div class="row" id="treatmentAffiche">

                                <c:forEach var="ProduitChoisi" varStatus="status" items="${sessionScope.listeSoins}"
                                           step="1" begin="0">

                                    <div class="col-3 text-left " id="pC${ProduitChoisi.idSoin}">

                                        <div class="card ">
                                            <img src="${ProduitChoisi.urlImage}" alt="${ProduitChoisi.nom}"
                                                 class="card-img-top">
                                            <div class="card-body">
                                                <h5 class="card-title">${ProduitChoisi.nom}</h5>
                                                <p class="card-text">${ProduitChoisi.description}</p>
                                                <p class="card-text">D'une durée de ${ProduitChoisi.duree} minute</p>
                                            </div>
                                            <ul class="list-group list-group-flush">
                                                <li class="list-group-item">${ProduitChoisi.prix}</li>
                                            </ul>
                                            <div class="card-footer">
                                                <a href="#" class="card-link">

                                                    <!-- ICI on a la zone de texte pour saisir la quantité -->
                                                    <fmt:message key="quantity"/>:<label>
                                                    <input type="text" name="quantite"
                                                           SIZE="3" value=1 id="${ProduitChoisi.idSoin}">
                                                </label>

                                                    <!--Ici on a un champ caché qui est renvoyé au controleur avec les autres
                                                    données de la requête. Puisque la servlet controleur va traiter les autres
                                                    demandes: Supprimer un élément du panier, commander (Checkout), ce champ caché
                                                    va être lu par la servlet pour déterminer le traitement à exécuter
                                                    -->
                                                    <input type="hidden" name="action" value="ADD">
                                                </a>
                                                <a href="#" class="card-link">
                                                    <!-- en cliquant sur ce bouton, la requête est envoyée à la servlet -->
                                                    <input type="button" name="Submit" onclick="submit()"
                                                           value="Ajouter au panier">
                                                </a>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>


                            </div>
                        </form>
                        <!---------------------------------------------------fin de affichage----------------------------------------------------->
                    </div>

                </div>
            </div>
        </div>
    </div>

</div>
<script src="https://unpkg.com/@popperjs/core@2"></script>
<script src="js/script.js"></script>
<script src="js/bootstrap.bundle.min.js"></script>


</body>
</html>
