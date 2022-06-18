<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Excellence Massothérapie</title>
    <!-- Favicon-->
    <link rel="icon" type="image/x-icon" href="img/icon.jpg"/>
    <!-- Styles -->
    <link href="css/style.css" rel="stylesheet"/>
    <!--Bootstrap -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="https://bootstrap-colors-extended.herokuapp.com/bootstrap-colors.css"/>

</head>
<body>

<%--popup demande de persionnalisation pop over on Init demander nom complet--%>


<nav class="navbar navbar-expand-lg navbar-dark fixed-top" id="mainNav">
    <div class="container">
        <a class="navbar-brand" href="#page-top"><img src="assets/img/navbar-logo.svg" alt="..."/></a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive"
                aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            Menu
            <i class="fas fa-bars ms-1"></i>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav text-uppercase ms-auto py-4 py-lg-0">
                <li class="nav-item"><a class="nav-link" href="#Accueil">Accueil</a></li>
                <li class="nav-item"><a class="nav-link" href="#Professionnel">Professionnel</a></li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#Produits_Services" id=navbarDropdownMenuProduitsServices"
                       role="button" data-toggle="dropdown" aria Dropdownlink></a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuProduitsServices">
                    <a class="dropdown-item" href="produits">Produits</a>
                    <a class="dropdown-item" href="soins">Soins</a>
                    </div>
                </li>
                <li class="nav-item"><a class="nav-link" href="#Panier">Panier</a></li>
                <li class="nav-item"><a class="nav-link" href="#Langue">
                    <select>
                        <option disabled="disabled">Langue</option>
                        <option name="francais"><a href="accueil.jsp?locale=en_FR">Français</a></option>
                        <option name="english"><a href="accueil.jsp?locale=en_EN">English</a></option>
                    </select></a></li>
                <li class="nav-item"><a class="nav-link" href="#connexion">
                    <select>
                        <option disabled="disabled">Compte</option>
                        <option name="connecter">Se connecter</option>
                        <option name="enregistrer">S'enregistrer</option>
                    </select></a></li>

            </ul>
        </div>
    </div>
</nav>
<!-- Masthead-->
<header class="masthead">
    <div class="container">
        <div class="masthead-subheading">Bienvenue</div>
    </div>
</header>


<!-- Bootstrap core JS-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<!-- Core theme JS-->
<script src="${pageContext.request.contextPath}/js/script.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap/jquery-3.6.0.min.js"></script>
</body>
</html>