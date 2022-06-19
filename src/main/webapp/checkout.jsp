<%--
  Created by IntelliJ IDEA.
  User: soul-
  Date: 2022-06-05
  Time: 10:53 a.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--VOIR ICI POURQUOI C'EST EN ROUGE (A ÉTÉ COPIÉ DU TP PANIER DE LA PROF--%>
<%@page session="true" import="java.util.*,modele.Produit" %>
<%@page session="true" import="java.util.*,modele.Soin" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="panier" value="${sessionScope.panierAchat}" />
<html>
<head>
    <title>checkout panier - Excellence Massothérapie</title>
</head>
<body bgcolor="#33CCFF">
<font face="Times New Roman,Times" size=+3>
    Finalisation de votre panier d'Excellence Massothérapie
</font>
<hr><p>
    <center>

<table border="0" cellpadding="0" width="100%" bgcolor="#FFFFFF">
    <tr>
        <td><b>Nom</b></td>
        <td><b>Descritpion</b></td>
        <td><b>Quantité</b></td>
        <td><b>Prix unitaire</b></td>
        <td><b>Total</b></td>
        <td></td>
    </tr>


    <c:forEach var="uneCommande" items="${sessionScope.panierAchat}"  >
        <tr>
            <td><b>${uneCommande.nom}</b></td>
            <td><b>${uneCommande.description}</b></td>
            <td><b>${uneCommande.quantite}</b></td>
            <td><b>${uneCommande.prix}</b></td>
            <td><b>${uneCommande.total}</b></td>
        </tr>
    </c:forEach>


    <tr>
        <td>     </td>
        <td>     </td>
        <td><b>TOTAL</b></td>
        <td><b>${requestScope.amount}</b></td>
        <td>     </td>
    </tr>
</table>




<%-- <c:remove var="panier" scope="session" /> --%>




<p>
    <a href="ClearCart" name="clearcart">Passer une nouvelle commande</a>
    <!-- <a href="EShop.jsp">Continuer à magasiner!</a> -->
    </center>
</body>
</html>
