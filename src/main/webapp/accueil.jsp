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
    <link rel="stylesheet" href="css/style.css"/>
    <link rel="stylesheet" href="bootstrap/bootstrap-grid.min.css"/>
    <link rel="stylesheet" href="bootstrap/bootstrap-reboot.min.css"/>
    <link rel="stylesheet" href="bootstrap/bootstrap.min.css"/>
    <link rel="stylesheet" href="https://bootstrap-colors-extended.herokuapp.com/bootstrap-colors.css" />

</head>
<body>

<div class="bg-teal-light">
<jsp:include page="navBar.jsp"  />
<img src="img/table.jpg" width=100%>



</div>


<script src="${pageContext.request.contextPath}js/script.js"></script>
<script src="${pageContext.request.contextPath}bootstrap/bootstrap.bundle.min.js"></script>
<script src="${pageContext.request.contextPath}bootstrap/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}bootstrap/jquery-3.6.0.min.js"></script>
<script src="https://unpkg.com/@popperjs/core@2"></script>
</body>
</html>