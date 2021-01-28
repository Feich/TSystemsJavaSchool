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
    <title>Drivers</title>
</head>
<body>
<h1>Drivers</h1>
<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Surname</th>
        <th>PhoneNumber</th>
        <th>Hours</th>
        <th>Status</th>
        <th>City</th>
        <th>Truck</th>
    </tr>
    <c:forEach var = "driver" items = "${driversList}">
        <tr>
            <td>${driver.id}</td>
            <td>${driver.name}</td>
            <td>${driver.surname}</td>
            <td>${driver.phoneNumber}</td>
            <td>${driver.hours}</td>
            <td>${driver.status}</td>
            <td>${driver.currentCity}</td>
            <td>${driver.truck.number}</td>
            <td>
                <a href="/editDriver/${driver.id}">edit</a>
                <a href="/deleteDriver/${driver.id}">delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

<h2>Add</h2>
<c:url value="/addDriver" var="addDriver"/>
<a href="${addDriver}">Add new driver</a>
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
