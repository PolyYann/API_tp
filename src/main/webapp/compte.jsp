<%--
  Created by IntelliJ IDEA.
  User: Mélanie
  Date: 2022-06-18
  Time: 09:12
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Connection</title>
</head>
<body>
<%--<c:choose> -->--%>
<%--    <c:when affichagecompte = enregistrer> -->--%>
<form name="senregistrer" action="senregistrer" method="get">

    <table border="1">
        <thead>
        <tr>
            <th colspan=2>Veuillez entrer vos coordonnées</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>Nom</td>
            <td><input type="text" name="nom" value=""/></td>
        </tr>
        <tr>
            <td>Téléphone</td>
            <td><input type="text" name="telephone" value=""/></td>
        </tr>
        <tr>
            <td>Courriel</td>
            <td><input type="text" name="courriel" value=""/></td>
        </tr>
        <tr>
            <td>Adresse</td>
            <td><input type="text" name="adresse" value=""/></td>
        </tr>
        <tr>
            <td>Mot de passe</td>
            <td><input type="text" name="mdp" value=""/></td>
        </tr>
        <tr align="center">
            <td colspan="2"><input type="submit" value="Enregistrer"/></td>
        </tr>
        </tbody>
    </table>
    <br>
    <%--    </c:when>--%>

    <%--<c:when affichagecompte = connecter> -->--%>
    <br>
    <table border="1">
        <thead>
        <tr>
            <th colspan=2>Veuillez saisir vos informations de connexion</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>Nom</td>
            <td><input type="text" name="nom" value=""/></td>
        </tr>
        <tr>
            <td>Mot de passe</td>
            <td><input type="text" name="mdp" value=""/></td>
        </tr>
        <tr align="center">
            <td colspan="2"><input type="submit" value="Envoyer"/></td>
        </tr>
        </tbody>
    </table>
    <%--    </c:when>--%>
    <%--    </c:choose>--%>

</form>
</body>
</html>
