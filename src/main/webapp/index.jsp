<%--
  Created by IntelliJ IDEA.
  User: Mélanie
  Date: 2022-06-18
  Time: 13:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Excellence Massothérapie</title>
    <!-- Favicon-->
    <link rel="icon" type="image/x-icon" href="img/icon.jpg"/>
    <!--Bootstrap -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}css/style.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}bootstrap/bootstrap-grid.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}bootstrap/bootstrap-reboot.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}bootstrap/bootstrap.min.css"/>
    <link rel="stylesheet" href="https://bootstrap-colors-extended.herokuapp.com/bootstrap-colors.css" />

</head>
<body>


<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">Excellence Massotherapie</a>
    <button class="navbar-toggler " type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavDropdown">
        <ul class="navbar-nav align-content-end" >
            <li class="nav-item active">
                <a class="nav-link" href="#">Accueil <span class="sr-only"></span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Produits et services</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Professionnels</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Langue</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Se connecter</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">s'enregistrer</a>
            </li>
        </ul>
    </div>
</nav>
<img src="img/table.jpg" width=100%>













<script src="${pageContext.request.contextPath}js/script.js"></script>
<script src="${pageContext.request.contextPath}bootstrap/bootstrap.bundle.min.js"></script>
<script src="${pageContext.request.contextPath}bootstrap/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}bootstrap/jquery-3.6.0.min.js"></script>
<script src="https://unpkg.com/@popperjs/core@2"></script>
</body>
</html>