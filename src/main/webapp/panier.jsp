


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--VOIR ICI POURQUOI C'EST EN ROUGE (A ÉTÉ COPIÉ DU TP PANIER DE LA PROF--%>
<%@page session="true" import="java.util.*,modele.Produit" %>
<%@page session="true" import="java.util.*,modele.Soin" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<center>
    <table border="0" cellpadding="0" width="100%" bgcolor="#FFFFFF">
        <thead>
        <tr>
            <th colspan="6">Liste des produits</th>
        </tr>
        </thead>
        <tr>
            <td><b>Nom</b></td>
            <td><b>Description</b></td>
            <td><b>Quantité</b></td>
            <td><b>Prix unitaire</b></td>
            <td><b>Total</b></td>
            <td></td>
        </tr>

        <c:forEach var="faireChoix" items="${sessionScope.panierAchat}" varStatus="loop" >
            <tr>
                <td><b>${faireChoix.nom}</b></td>
                <td><b>${faireChoix.description}</b></td>
                <td><b>${faireChoix.quantite}</b></td>
                <td><b>${faireChoix.prix}</b></td>
                <td><b>${faireChoix.total}</b></td>
                <td>
                    <form name="deleteForm" action="panierServlet" method="POST">
                        <input type="submit" value="Delete">

                        <input type="hidden" name="delindex" value="${loop.index}">

                        <input type="hidden" name="action" value="DELETE">
                    </form>
                </td>
            </tr>
        </c:forEach>

    </table>

    <table border="0" cellpadding="0" width="100%" bgcolor="#FFFFFF">
        <thead>
        <tr>
            <th colspan="6">Liste des soins</th>
        </tr>
        </thead>
        <tr>
            <td><b>Nom</b></td>
            <td><b>Description</b></td>
            <td><b>Quantité</b></td>
            <td><b>Prix unitaire</b></td>
            <td><b>Total</b></td>
            <td></td>
        </tr>

        <c:forEach var="soin" items="${sessionScope.panierAchat}"  varStatus="loop" >
            <tr>
                <td><b>${soin.nom}</b></td>
                <td><b>${soin.description}</b></td>
                <td><b>${soin.quantite}</b></td>
                <td><b>${soin.prix}</b></td>
                <td><b>${soin.total}</b></td>
                <td>
                    <form name="deleteForm" action="panierServlet" method="POST">
                        <input type="submit" value="Delete">

                        <input type="hidden" name="delindex" value="${loop.index}">

                        <input type="hidden" name="action" value="DELETE">
                    </form>
                </td>
            </tr>
        </c:forEach>

    </table>
    <p>
    <form name="checkoutForm" action="panierServlet"  method="POST">
        <input type="hidden" name="action" value="CHECKOUT">
        <input type="submit" name="Checkout" value="Checkout">
    </form>
</center>

