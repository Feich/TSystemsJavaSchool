<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Feich
  Date: 29.12.2020
  Time: 14:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <c:if test="${empty routePoint.id}">
        <title>Add RoutePoint</title>
    </c:if>
    <c:if test="${!empty routePoint.id}">
        <title>Edit RoutePoint</title>
    </c:if>
</head>
<body>
<c:if test="${empty routePoint.id}">
    <c:url value="/addRoutePoint" var="var"/>
</c:if>
<c:if test="${!empty routePoint.id}">
    <c:url value="/editRoutePoint" var="var"/>
</c:if>
<form action = "${var}" method = "POST">
    <c:if test="${!empty routePoint.id}">
        <input type="hidden" name="id" value="${routePoint.id}">
    </c:if>
    <label for = "currentCity">Current City</label>
    <input type="text" name="currentCity" id="currentCity">
    <c:if test="${empty routePoint.id}">
        <input type="submit" value="add routePoint">
    </c:if>
    <c:if test="${!empty routePoint.id}">
        <input type="submit" value="edit routePoint">
    </c:if>

</form>

</body>
</html>
