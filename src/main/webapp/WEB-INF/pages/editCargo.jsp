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
    <c:if test="${empty cargo.name}">
        <title>Add Cargo</title>
    </c:if>
    <c:if test="${!empty cargo.name}">
        <title>Edit Cargo</title>
    </c:if>
</head>
<body>
<c:if test="${empty cargo.id}">
    <c:url value="/addCargo" var="var"/>
</c:if>
<c:if test="${!empty cargo.id}">
    <c:url value="/editCargo" var="var"/>
</c:if>
<form action = "${var}" method = "POST">
    <c:if test="${!empty cargo.id}">
        <input type="hidden" name="id" value="${cargo.id}">
    </c:if>
    <label for = "name">Name</label>
    <input type="text" name="name" id="name">
    <label for = "weight">Weight</label>
    <input type="text" name="weight" id="weight">
    <label for = "status">Status</label>
    <input type="text" name="status" id="status">
    <c:if test="${empty cargo.name}">
        <input type="submit" value="add cargo">
    </c:if>
    <c:if test="${!empty cargo.name}">
        <input type="submit" value="edit cargo">
    </c:if>

</form>
</body>
</html>
