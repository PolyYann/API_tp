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
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<fmt:setLocale value="${sessionScope.langue}" scope="session"/>
<!-- balise fmt:setLocale mentionne qu'on veut les infos contenues dans la value local (loc) -->

<fmt:setBundle basename="app"/><!-- basename=app ça veut dire que le fichier commence par app.-->

<title><fmt:message key="excellence"/></title>
<!-- Favicon-->
<link rel="icon" type="image/x-icon" href="img/icon.jpg"/>




<div class="col-lg-4 bg-grey">
    <div class="p-5">
        <h3 class="fw-bold mb-5 mt-2 pt-1"><fmt:message key="summary"/></h3>
     <!--   <hr class="my-4"> -->


        <hr class="my-4">
        <div class="d-flex justify-content-between mb-5">
            <h5 class="text-uppercase"><fmt:message key="totalInvoice"/></h5>
            <h5>${sessionScope.totalPanier} $</h5>
        </div>

        <form name="checkoutForm" action="ServletPanier"  method="post">
            <input type="hidden" name="action" value="checkout">
            <input type="submit" name="payer" value="<fmt:message key="pay"/>">

        </form>


    </div>
</div>




