<%--
  Created by IntelliJ IDEA.
  User: Mélanie
  Date: 2022-06-18
  Time: 13:14
  To change this template use File | Settings | File Templates.
--%>
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
    <link rel="stylesheet" href="bootstrap/bootstrap-grid.min.css"/>
    <link rel="stylesheet" href="bootstrap/bootstrap-reboot.min.css"/>
    <link rel="stylesheet" href="bootstrap/bootstrap.min.css"/>
    <link rel="stylesheet" href="https://bootstrap-colors-extended.herokuapp.com/bootstrap-colors.css"/>


</head>
<body>

<div class="bg-steal-light carousel">
    <jsp:include page="navBar.jsp"/>
    <div class="">
        <div class="row-cols-auto">
            <img class="w-100 h-100  overflow-hidden" src="img/table.jpg" alt="">
        </div>
        <div class="carousel-caption center-block">
            <h1><fmt:message key="welcome"/></h1>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>


            <h5><fmt:message key="language"/></h5>
            <form name="formLangue" action="LanguageServlet" methode="post">


                <select name="langue" onchange="submit()">
                    <option value=""><fmt:message key="select_one"/></option>
                    <option value="fr"><fmt:message key="french"/></option>
                    <option value="en"><fmt:message key="english"/></option>
                </select>
                <input type="hidden" name="src" value="1"/>
         <!--       <button type="submit" class="btn btn-outline-secondary btn-sm">Submit</button> -->

            </form>
        </div>
    </div>
</div>


<script src="js/script.js"></script>
<script src="bootstrap/bootstrap.bundle.min.js"></script>
<script src="bootstrap/bootstrap.min.js"></script>
<script src="bootstrap/jquery-3.6.0.min.js"></script>
<script src="https://unpkg.com/@popperjs/core@2"></script>
</body>
</html>