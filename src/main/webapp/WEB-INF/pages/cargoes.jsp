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
    <title>Cargoes</title>
</head>
<body>
<h1>Cargoes</h1>
<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Weight</th>
        <th>Status</th>
        <th>Truck</th>
        <th>Order</th>
        <th>Shipment</th>
        <th>Discharge</th>
    </tr>
<c:forEach var = "cargo" items = "${cargoesList}">
    <tr>
        <td>${cargo.id}</td>
        <td>${cargo.name}</td>
        <td>${cargo.weight}</td>
        <td>${cargo.status}</td>
        <td>${cargo.truck.number}</td>
        <td>${cargo.order.id}</td>
        <td>${cargo.shipmentPoint.city}</td>
        <td>${cargo.dischargePoint.city}</td>
        <td>
            <a href="/editCargo/${cargo.id}">edit</a>
            <a href="/deleteCargo/${cargo.id}">delete</a>
        </td>
    </tr>
</c:forEach>
</table>
<c:if test="${!empty orderId}">
    <h2>Add</h2>
    <c:url value="/addCargo" var="addCargo"/>
    <a href="${addCargo}">Add new cargo</a>
</c:if>
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
