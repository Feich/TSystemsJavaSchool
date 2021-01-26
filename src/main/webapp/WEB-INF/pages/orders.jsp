<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Feich
  Date: 29.12.2020
  Time: 2:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ORDERS</title>
</head>
<body>
<h1>Orders</h1>
<table>
    <tr>
        <th>Id</th>
        <th>Status</th>
        <th>Truck</th>
        <th>Cargoes</th>
        <th>Drivers</th>
        <th>RoutePoints</th>
    </tr>
    <c:forEach var = "order" items = "${ordersList}">
        <tr>
            <td>${order.id}</td>
            <td>${order.status}</td>
            <td>
                <a href="/truckInOrder/${order.id}">truck</a>
            </td>
            <td>
                <a href="/cargoesInOrder/${order.id}">cargoes</a>
            </td>
            <td>
                <a href="/driversInOrder/${order.id}">drivers</a>
            </td>
            <td>
                <a href="/routePointsInOrder/${order.id}">Route Points</a>
            </td>
            <td>
                <a href="/editOrder/${order.id}">edit</a>
                <a href="/deleteOrder/${order.id}">delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

<h2>Add Order</h2>
<c:url value="/addOrder" var="addOrder"/>
<a href="${addOrder}">Add new order</a>
<p>
    <c:url value="/trucks" var="trucks"/>
    <a href="${trucks}">Trucks</a>
    <c:url value="/cargoes" var="cargoes"/>
    <a href="${cargoes}">Cargoes</a>
    <c:url value="/orders" var="orders"/>
    <a href="${orders}">Orders</a>
    <c:url value="/drivers" var="drivers"/>
    <a href="${drivers}">Drivers</a>
    <c:url value="/routePoints" var="routePoints"/>
    <a href="${routePoints}">Route Points</a>
</p>
</body>
</html>
