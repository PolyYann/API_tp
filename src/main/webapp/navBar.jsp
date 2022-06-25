<%--
  Created by IntelliJ IDEA.
  User: Mélanie
  Date: 2022-06-24
  Time: 12:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">Excellence Massotherapie</a>
    <button class="navbar-toggler " type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavDropdown">
        <ul class="navbar-nav align-content-end" >
            <li class="nav-item active">
                <a class="nav-link" href="accueil.jsp">Accueil <span class="sr-only"></span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="affichageProduitsServices.jsp">Produits et services</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="afficherProfessionnels.jsp">Professionnels</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="LocaleServlet">Langue</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="connection.jsp">Se connecter<input type="hidden" name="action" value="login"></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="connection.jsp">s'enregistrer<input type="hidden" name="action" value="createaccount"></a>
            </li>
        </ul>
    </div>
</nav>
