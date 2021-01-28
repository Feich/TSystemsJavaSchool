<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Feich
  Date: 29.12.2020
  Time: 2:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>ROUTE POINTS</title>
</head>
<body>
<h1>Route Points</h1>
<table>
    <tr>
        <th>Id</th>
        <th>City</th>
        <th>Cargoes for shipment</th>
        <th>Cargoes for discharge</th>
        <th>Order</th>
    </tr>
    <c:forEach var = "routePoint" items = "${routePointsList}">
        <tr>
            <td>${routePoint.id}</td>
            <td>${routePoint.city}</td>
            <td>
                <a href="/cargoesForShipment/${routePoint.id}">Cargoes for shipment</a>
            </td>
            <td>
                <a href="/cargoesForDischarge/${routePoint.id}">Cargoes for discharge</a>
            </td>
            <td>
                <a href="/orderByRoutePoint/${routePoint.id}">Order</a>
            </td>
            <td>
                <a href="/editRoutePoint/${routePoint.id}">edit</a>
                <a href="/deleteRoutePoint/${routePoint.id}">delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

<h2>Add</h2>
<c:url value="/addRoutePoint" var="addRoutePoint"/>
<a href="${addRoutePoint}">Add new routePoint</a>
<p>
    <c:url value="/trucks" var="trucks"/>
    <a href="${trucks}">Trucks</a>
    <c:url value="/cargoes" var="cargoes"/>
    <a href="${cargoes}">Cargoes</a>
    <c:url value="/orders" var="orders"/>
    <a href="${orders}">Orders</a>
    <c:url value="/drivers" var="drivers"/>
    <a href="${drivers}">Drivers</a>
</p>
</body>
</html>
