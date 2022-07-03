<%--
  Created by IntelliJ IDEA.
  User: Mélanie
  Date: 2022-06-24
  Time: 12:22
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

                    <div class="col-12">
                        <h1><fmt:message key="profList"/></h1>
                        <!---------------------------------------------------Début de la boucle pour affichage----------------------------------------------------->
                        <div class="row" id="profAffiche">

                            <c:forEach var="Prof" varStatus="loop" items="${sessionScope.listeProfs}"
                                       step="1" begin="0">
                                <div class="col-3">
                                    <div class="card ">
                                        <img src="${Prof.urlImage}" alt="${Prof.nom}"
                                             class="card-img-top">
                                        <div class="card-body">
                                            <h5 class="card-title">${Prof.nom}</h5>
                                            <p class="card-text">${Prof.presentation}</p>
                                        </div>

                                        <div class="card-footer">

                                        </div>
                                    </div>

                                </div>
                            </c:forEach>
                        </div>
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
