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
    <title>CARGOES</title>
</head>
<h1>Cargoes</h1>
<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Weight</th>
        <th>Status</th>
        <th>Truck Id</th>
    </tr>
<c:forEach var = "cargo" items = "${cargoesList}">
    <tr>
        <td>${cargo.id}</td>
        <td>${cargo.name}</td>
        <td>${cargo.weight}</td>
        <td>${cargo.status}</td>
        <td>${cargo.truck.number}</td>
        <td>
            <a href="/editCargo/${cargo.id}">edit</a>
            <a href="/deleteCargo/${cargo.id}">delete</a>
        </td>
    </tr>
</c:forEach>
</table>

<h2>Add</h2>
<c:url value="/addCargo" var="addCargo"/>
<a href="${addCargo}">Add new cargo</a>
<h2>Trucks</h2>
<c:url value="/" var="trucks"/>
<a href="${trucks}">Trucks</a>
</body>
</html>
