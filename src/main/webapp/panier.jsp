


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<html>
<head>
    <fmt:setLocale value="${sessionScope.langue}" scope="session"/>
    <!-- balise fmt:setLocale mentionne qu'on veut les infos contenues dans la value local (loc) -->

    <fmt:setBundle basename="app"/><!-- basename=app ça veut dire que le fichier commence par app.-->

    <title><fmt:message key="excellence"/></title>
    <!-- Favicon-->
    <link rel="icon" type="image/x-icon" href="img/icon.jpg"/>
    <!--Bootstrap -->
    <link rel="stylesheet" href="css/style.css"/>
    <link rel="stylesheet" href="css/bootstrap-grid.min.css"/>
    <link rel="stylesheet" href="bootstrap/bootstrap-reboot.min.css"/>
    <link rel="stylesheet" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" href="https://bootstrap-colors-extended.herokuapp.com/bootstrap-colors.css"/>


</head>
<body>
<div class="bg-steel-light">
    <jsp:include page="navBar.jsp"/>
    <br>
    <br>
    <br>

    <section class="h-100 h-custom" >
        <div class="container py-5 h-100">
            <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="col-12">
                    <div class="card card-registration card-registration-2" style="border-radius: 15px;">
                        <div class="card-body p-0">
                            <div class="row g-0">
                                <div class="col-lg-8">
                                    <div class="p-5">
                                        <div class="d-flex justify-content-between align-items-center mb-5">
                                            <h1 class="fw-bold mb-0 text-black">Panier</h1>
                                        </div>

                                        <hr class="my-4">

                                        <div class="row mb-4 d-flex justify-content-between align-items-center">
                                            <div class="col-md-2 col-lg-2 col-xl-2">
                                                <img src="insérer ici :  $ {choix.urlImage}" class="img-fluid rounded-3"alt="${choix.nom}">
                                            </div>
                                            <div class="col-md-3 col-lg-3 col-xl-3">
                                                <h6 class="text-muted">insérer ici :  $ {choix.nom}</h6>
                                                <h6 class="text-black mb-0">insérer ici :  $ {choix.description}</h6>
                                            </div>
                                            <div class="col-md-3 col-lg-3 col-xl-2 d-flex">
                                                <button class="btn btn-link px-2"
                                                        onclick="this.parentNode.querySelector('input[type=number]').stepDown()">
                                                    <i class="fas fa-minus"></i>
                                                </button>

                                                <input id="form1" min="0" name="quantity" value="1" type="number"
                                                       class="form-control form-control-sm" />

                                                <button class="btn btn-link px-2"
                                                        onclick="this.parentNode.querySelector('input[type=number]').stepUp()">
                                                    <i class="fas fa-plus"></i>
                                                </button>
                                            </div>
                                            <div class="col-md-3 col-lg-2 col-xl-2 offset-lg-1">
                                                <h6 class="mb-0">insérer ici :  $ {choix.prix}</h6>
                                            </div>
                                            <div class="col-md-3 col-lg-2 col-xl-2 offset-lg-1">
                                                <h6 class="mb-0">insérer ici :  $ {choix.total}</h6>
                                            </div>
                                            <div class="col-md-1 col-lg-1 col-xl-1 text-end">
                                                <a href="#!" class="text-muted"><i class="fas fa-times"></i></a>
                                            </div>
                                        </div>

                                        <hr class="my-4">

                                        <div class="row mb-4 d-flex justify-content-between align-items-center">
                                            <div class="col-md-2 col-lg-2 col-xl-2">
                                                <img
                                                        src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-shopping-carts/img6.webp"
                                                        class="img-fluid rounded-3" alt="Cotton T-shirt">
                                            </div>
                                            <div class="col-md-3 col-lg-3 col-xl-3">
                                                <h6 class="text-muted">Shirt</h6>
                                                <h6 class="text-black mb-0">Cotton T-shirt</h6>
                                            </div>
                                            <div class="col-md-3 col-lg-3 col-xl-2 d-flex">
                                                <button class="btn btn-link px-2"
                                                        onclick="this.parentNode.querySelector('input[type=number]').stepDown()">
                                                    <i class="fas fa-minus"></i>
                                                </button>

                                                <input id="form1" min="0" name="quantity" value="1" type="number"
                                                       class="form-control form-control-sm" />

                                                <button class="btn btn-link px-2"
                                                        onclick="this.parentNode.querySelector('input[type=number]').stepUp()">
                                                    <i class="fas fa-plus"></i>
                                                </button>
                                            </div>
                                            <div class="col-md-3 col-lg-2 col-xl-2 offset-lg-1">
                                                <h6 class="mb-0">€ 44.00</h6>
                                            </div>
                                            <div class="col-md-1 col-lg-1 col-xl-1 text-end">
                                                <a href="#!" class="text-muted"><i class="fas fa-times"></i></a>
                                            </div>
                                        </div>

                <!-- partie pour retourner magasiner--------------------------------------------->

                                        <hr class="my-4">
                                        <div class="pt-5">
                                            <h6 class="mb-0"><a href="ServletAffichage" class="text-body"><i
                                                    class="fas fa-long-arrow-alt-left me-2"></i>Continuer à magasiner</a></h6>
                                        </div>
                                    </div>
                                </div>
                 <!-- partie pour passer au checkout--------------------------------------------->

                                <div class="col-lg-4 bg-grey">
                                    <div class="p-5">
                                        <h3 class="fw-bold mb-5 mt-2 pt-1">Sommaire</h3>
                                        <hr class="my-4">

                                        <hr class="my-4">

                                        <div class="d-flex justify-content-between mb-5">
                                            <h5 class="text-uppercase">Total facture</h5>
                                            <h5>insérer ici un $ {choix.grandTotal}</h5>
                                        </div>

                                        <button type="button" class="btn btn-dark btn-block btn-lg"
                                                data-mdb-ripple-color="dark">Payer</button>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-----------------------------------------------------------------code du prof -----------------------------------------------
    <table border="0" cellpadding="0" width="100%" bgcolor="#FFFFFF">
        <thead>
        <tr>
            <th colspan="6">Liste des produits</th>
        </tr>
        </thead>
        <tr>
            <td><b>Nom</b></td>
            <td><b>Description</b></td>
            <td><b>Quantité</b></td>
            <td><b>Prix unitaire</b></td>
            <td><b>Total</b></td>
            <td></td>
        </tr>

        <c:forEach var="faireChoix" items="${sessionScope.panierAchat}" varStatus="loop" >
            <tr>
                <td><b>${faireChoix.nom}</b></td>
                <td><b>${faireChoix.description}</b></td>
                <td><b>${faireChoix.quantite}</b></td>
                <td><b>${faireChoix.prix}</b></td>
                <td><b>${faireChoix.total}</b></td>
                <td>
                    <form name="deleteForm" action="panierServlet" method="POST">
                        <input type="submit" value="Delete">

                        <input type="hidden" name="delindex" value="${loop.index}">

                        <input type="hidden" name="action" value="DELETE">
                    </form>
                </td>
            </tr>
        </c:forEach>

    </table>

    <table border="0" cellpadding="0" width="100%" bgcolor="#FFFFFF">
        <thead>
        <tr>
            <th colspan="6">Liste des soins</th>
        </tr>
        </thead>
        <tr>
            <td><b>Nom</b></td>
            <td><b>Description</b></td>
            <td><b>Quantité</b></td>
            <td><b>Prix unitaire</b></td>
            <td><b>Total</b></td>
            <td></td>
        </tr>

        <c:forEach var="soin" items="${sessionScope.panierAchat}" varStatus="loop">
            <tr>
                <td><b>${soin.nom}</b></td>
                <td><b>${soin.description}</b></td>
                <td><b>${soin.quantite}</b></td>
                <td><b>${soin.prix}</b></td>
                <td><b>${soin.total}</b></td>
                <td>
                    <form name="deleteForm" action="panierServlet" method="POST">
                        <input type="submit" value="Delete">

                        <input type="hidden" name="delindex" value="${loop.index}">

                        <input type="hidden" name="action" value="DELETE">
                    </form>
                </td>
            </tr>
        </c:forEach>

    </table>
    <p>
    <form name="checkoutForm" action="panierServlet" method="POST">
        <input type="hidden" name="action" value="CHECKOUT">
        <input type="submit" name="Checkout" value="Checkout">
    </form>

---------------------------------------------------------------code du prof ----------------------------------------------->
</div>
<script src="js/script.js"></script>
<script src="bootstrap/bootstrap.bundle.min.js"></script>
<script src="bootstrap/bootstrap.min.js"></script>
<script src="bootstrap/jquery-3.6.0.min.js"></script>
<script src="https://unpkg.com/@popperjs/core@2"></script>
</body>
</html>

