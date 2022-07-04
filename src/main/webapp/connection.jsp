<%--
  Created by IntelliJ IDEA.
  User: Mélanie
  Date: 2022-06-24
  Time: 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
    <link rel="stylesheet" href="https://bootstrap-colors-extended.herokuapp.com/bootstrap-colors.css" />


</head>
<body>

<div class="bg-steel-light">
    <jsp:include page="navBar.jsp"  />

    <form name="maformConnection" action="ServletConnection" method="post">

        <section class="text-center text-lg-start">
            <style>
                .cascading-right {
                    margin-right: -50px;
                }

                @media (max-width: 991.98px) {
                    .cascading-right {
                        margin-right: 0;
                    }
                }
            </style>


            <div class="container py-4">
                <div class="row g-0 align-items-center">
                    <div class="col-lg-6 mb-5 mb-lg-0">
                        <div class="card cascading-right" style="
            background: hsla(0, 0%, 100%, 0.55);
            backdrop-filter: blur(30px);
            ">
                            <div class="card-body p-5 shadow-5 text-center">
                                <h2 class="fw-bold mb-5">
                                    <c:set var="action" scope="session" value="${sessionScope.action}"></c:set>
                                    <c:if test="${param.action==\"signin\"}">
                                        <fmt:message key="signin"/>
                                    </c:if>

                                    <c:if test="${param.action==\"signup\"}">
                                        <fmt:message key="signup"/>
                                    </c:if>

                                </h2>
                                <form name="connForm" action="ServletConnection">
                                    <!-- 2 column grid layout with text inputs for the name and password -->
                                    <div class="row">
                                        <div class="col-md-6 mb-4">
                                            <div class="form-outline">
                                                <label class="form-label" ><input type="text" name="nom" id="nom" class="form-control" />
                                                <fmt:message key="name"/></label>
                                            </div>
                                        </div>
                                        <div class="col-md-6 mb-4">
                                            <div class="form-outline mb-4">
                                                <input type="password" name="password" class="form-control" />
                                                <label class="form-label"><fmt:message key="password"/></label>
                                            </div>
                                        </div>
                                    </div>
                                    <c:if test="${param.action==\"signup\"}">
                                        <jsp:include page="enregistrer.jsp"/>
                                    </c:if>


                                    <!-- Submit button -->
                                    <c:if test="${param.action==\"signin\"}">
                                        <button  type="submit" name="send" value="signin" class="btn btn-secondary btn-block mb-4">
                                            <fmt:message key="signin"/>
                                        </button>
                                    </c:if>

                                    <c:if test="${param.action==\"signup\"}">
                                        <button  type="submit" name="send" value="signup" class="btn btn-secondary btn-block mb-4">
                                            <fmt:message key="signup"/>
                                        </button>
                                    </c:if>

                                </form>
                            </div>
                        </div>
                    </div>

                    <div class="col-lg-6 mb-5 mb-lg-0">
                        <img src="img/icon.png" class="w-100 rounded-4 shadow-4"
                             alt="" />
                    </div>
                </div>
            </div>
        </section>
    </form>

</div>


<script src="js/script.js"></script>
<script src="js/bootstrap.bundle.min.js"></script>
<script src="bootstrap/bootstrap.bundle.js"></script>
<script src="bootstrap/bootstrap.min.js"></script>
<script src="bootstrap/jquery-3.6.0.min.js"></script>
<script src="https://unpkg.com/@popperjs/core@2"></script>


</body>
</html>


