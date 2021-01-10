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
    <c:if test="${empty truck.number}">
        <title>Add Truck</title>
    </c:if>
    <c:if test="${!empty truck.number}">
        <title>Edit Truck</title>
    </c:if>
</head>
<body>
<c:if test="${empty truck.id}">
    <c:url value="/addTruck" var="var"/>
</c:if>
<c:if test="${!empty truck.id}">
    <c:url value="/editTruck" var="var"/>
</c:if>
<form action = "${var}" method = "POST">
    <c:if test="${!empty truck.id}">
        <input type="hidden" name="id" value="${truck.id}">
    </c:if>
    <label for = "number">Number</label>
    <input type="text" name="number" id="number">
    <label for = "driverShiftSize">Shift Size</label>
    <input type="text" name="driverShiftSize" id="driverShiftSize">
    <label for = "capacity">Capacity</label>
    <input type="text" name="capacity" id="capacity">
    <label for = "currentCity">Current City</label>
    <input type="text" name="currentCity" id="currentCity">
    <label for = "status">Status</label>
    <select name="status" id = "status">
        <option value="OK">OK</option>
        <option value="DEFECTIVE">DEFECTIVE</option>
    </select>
    <c:if test="${empty truck.number}">
        <input type="submit" value="add truck">
    </c:if>
    <c:if test="${!empty truck.number}">
        <input type="submit" value="edit truck">
    </c:if>

</form>
</body>
</html>
