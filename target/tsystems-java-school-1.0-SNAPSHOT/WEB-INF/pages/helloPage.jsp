<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Feich
  Date: 22.01.2021
  Time: 18:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello, world!</title>
</head>
<body>
<h1>Hello, world!</h1>
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
