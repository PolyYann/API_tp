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


<fmt:setBundle basename="app"/><!-- basename=app ça veut dire que le fichier commence par app.-->
<!--on met un if pour voir si on change de langue-->

<fmt:setLocale
        value="${requestScope.langue}"/> <!-- balise fmt:setLocale mentionne qu'on veut les infos contenues dans la value local (loc) -->

<!-- Email input -->
<div class="form-outline mb-4">
    <input type="email" id="email" class="form-control" />
    <label class="form-label">Adresse courriel</label>
</div>
<div class="form-outline mb-4">
    <input type="text" id="phone" class="form-control" />
    <label class="form-label">Telephone</label>
</div>
<div class="form-outline mb-4">
    <input type="text" id="address" class="form-control" />
    <label class="form-label">Adresse</label>
</div>


