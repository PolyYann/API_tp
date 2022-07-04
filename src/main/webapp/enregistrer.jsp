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


<!-- Email input -->
<div class="form-outline mb-4">
    <input type="email" name="email" class="form-control" />
    <label class="form-label"><fmt:message key="email"/></label>
</div>
<div class="form-outline mb-4">
    <input type="text" name="phone" class="form-control" />
    <label class="form-label"><fmt:message key="phone"/></label>
</div>
<div class="form-outline mb-4">
    <input type="text" name="address" class="form-control" />
    <label class="form-label"><fmt:message key="address"/></label>
</div>
