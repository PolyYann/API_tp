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



<c:set var="loc" value="fr"/> <!-- Ici, la valeur fr_FR est codé en dure, comme une valeur par défaut -->

<fmt:setBundle basename="app"/><!-- basename=app ça veut dire que le fichier commence par app.-->
<!--on met un if pour voir si on change de langue-->


<nav class="navbar navbar-expand-lg fixed-top  navbar-light bg-light ">

    <a class="navbar-brand ps-5   " href="#">Excellence Massotherapie</a>
    <button class="navbar-toggler " type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup"
            aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse flex-row-reverse pe-5" id="navbarNavDropdown">
        <ul class="navbar-nav align-content-end">
            <li class="nav-item active">
                <a class="nav-link" href="accueil.jsp">Accueil <span class="sr-only"></span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="ServletAffichage"><fmt:message key="products_services"/></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="afficherProfessionnels.jsp"><fmt:message key="professional"/></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="LocaleServlet"><fmt:message key="language"/></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="connection.jsp"><fmt:message key="signin"/><input type="hidden" name="action" value="login"></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="connection.jsp"><fmt:message key="signup"/><input type="hidden" name="action" value="createaccount"></a>
            </li>
        </ul>
    </div>
</nav>
