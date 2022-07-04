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
    <link rel="stylesheet" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" href="https://bootstrap-colors-extended.herokuapp.com/bootstrap-colors.css"/>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

</head>
<body>
<div class="bg-steel-light">
    <jsp:include page="navBar.jsp"/>
    <br>
    <br>
    <br>

    <section class="h-100 h-custom">
        <div class="container py-5 h-100">
            <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="col-12">
                    <div class="card card-registration card-registration-2" style="border-radius: 15px;">
                        <div class="card-body p-0">
                            <div class="row g-0">
                                <div class="col-lg-8">
                                    <div class="p-5">
                                        <div class="d-flex justify-content-between align-items-center mb-5">
                                            <h1 class="fw-bold mb-0 text-black"><fmt:message key="cart"/></h1>
                                        </div>

                                        <hr class="my-4">
                                        <!--ajouter les lignes de produits---------------------------------->
                                        <c:forEach var="addedItem" varStatus="loop"
                                                   items="${sessionScope.listLigneCommande}" step="1" begin="0">
                                            <c:choose>
                                                <c:when test="${!empty addedItem.produit}">

                                                    <div class="row mb-4 d-flex justify-content-between align-items-center">
                                                        <div class="col-md-2 col-lg-2 col-xl-2">
                                                            <img src="${addedItem.produit.urlImage}"
                                                                 class="img-fluid rounded-3"
                                                                 alt="${addedItem.produit.nom}">
                                                        </div>
                                                        <div class="col-md-3 col-lg-3 col-xl-3">
                                                            <h6 class="text-black mb-0">${addedItem.produit.nom}</h6>
                                                        </div>
                                                        <div class="col-md-3 col-lg-3 col-xl-3">
                                                            <h6 class="text-black mb-0">Prix Unitaire</h6>
                                                           <h6 class="text-black mb-0">${addedItem.produit.prix}</h6>
                                                        </div>
                                                        <div class="col-md-3 col-lg-3 col-xl-2 d-flex">

                                                            <input id="formPanierProduit" min="0" name="quantity" value="${addedItem.quantite}"
                                                                   type="number" disabled="true"
                                                                   class="form-control form-control-sm"/>
                                                        </div>

                                                        <div class="col-md-1 col-lg-1 col-xl-1 text-end">
                                                            <a href="#!" class="text-muted"><i class="fas fa-times"></i></a>
                                                        </div>
                                                    </div>
                                                </c:when>

                                                <c:when test="${!empty addedItem.soin}">

                                                    <div class="row mb-4 d-flex justify-content-between align-items-center">
                                                        <div class="col-md-2 col-lg-2 col-xl-2">
                                                            <img src="${addedItem.soin.urlImage}"
                                                                 class="img-fluid rounded-3"
                                                                 alt="${addedItem.soin.nom}">
                                                        </div>
                                                        <div class="col-md-3 col-lg-3 col-xl-3">
                                                            <h6 class="text-black mb-0">${addedItem.soin.nom}</h6>
                                                        </div>
                                                        <div class="col-md-3 col-lg-3 col-xl-3">
                                                            <h6 class="text-black mb-0">Prix Unitaire</h6>
                                                            <h6 class="text-black mb-0">${addedItem.soin.prix}</h6>
                                                        </div>
                                                        <div class="col-md-3 col-lg-3 col-xl-2 d-flex">

                                                            <input id="formPanierSoin" min="0" name="quantity" value="${addedItem.quantite}"
                                                                   type="number" disabled="true"
                                                                   class="form-control form-control-sm"/>
                                                        </div>

                                                        <div class="col-md-1 col-lg-1 col-xl-1 text-end">
                                                            <a href="#!" class="text-muted"><i class="fas fa-times"></i></a>
                                                        </div>
                                                    </div>
                                                </c:when>
                                            </c:choose>
                                        </c:forEach>



                                        <div>
                                            <form name="checkoutForm" action="ServletPanier" method="post">
                                                <input type="hidden" name="action" value="checkout">
                                                <input type="submit" name="payer"
                                                       value="<fmt:message key="closeCart"/>">
                                            </form>
                                        </div>


                                        <!-- partie pour retourner magasiner--------------------------------------------->

                                        <hr class="my-4">
                                        <div class="pt-5">
                                            <c:if test="${param.action==\"checkout\"}">
                                                <%@include file="WEB-INF/fragmentUser.jspf" %>
                                            </c:if>
                                        </div>
                                        <hr class="my-4">
                                        <div class="pt-5">
                                            <h6 class="mb-0"><a href="ServletAffichage" class="text-body"><i
                                                    class="fas fa-long-arrow-alt-left me-2"></i><fmt:message
                                                    key="continueShopping"/></a></h6>
                                        </div>
                                    </div>
                                </div>
                                <!-- partie pour passer au checkout--------------------------------------------->
                                <c:if test="${param.action==\"checkout\"}">
                                    <jsp:include page="checkout.jsp"/>
                                </c:if>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>

</div>
<script src="js/script.js"></script>
<script src="js/bootstrap.bundle.min.js"></script>


<script src="https://unpkg.com/@popperjs/core@2"></script>
</body>
</html>

