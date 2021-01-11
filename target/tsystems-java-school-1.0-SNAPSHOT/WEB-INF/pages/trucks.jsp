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
    <title>TRUCKS</title>
</head>
<h1>Trucks</h1>
<table>
    <tr>
        <th>Id</th>
        <th>Number</th>
        <th>Capacity</th>
        <th>Shift Size</th>
        <th>Current City</th>
        <th>Status</th>
    </tr>
    <c:forEach var = "truck" items = "${trucksList}">
        <tr>
            <td>${truck.id}</td>
            <td>${truck.number}</td>
            <td>${truck.capacity}</td>
            <td>${truck.driverShiftSize}</td>
            <td>${truck.currentCity}</td>
            <td>${truck.status}</td>
            <td>
                <a href="/editTruck/${truck.id}">edit</a>
                <a href="/deleteTruck/${truck.id}">delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

<h2>Add</h2>
<c:url value="/addTruck" var="addTruck"/>
<a href="${addTruck}">Add new truck</a>

<h2>Cargoes</h2>
<c:url value="/cargoes" var="cargoes"/>
<a href="${cargoes}">Cargoes</a>
</body>
</html>
