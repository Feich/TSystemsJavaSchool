<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Feich
  Date: 29.12.2020
  Time: 14:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <c:if test="${empty driver.name}">
        <title>Add Driver</title>
    </c:if>
    <c:if test="${!empty driver.name}">
        <title>Edit Driver</title>
    </c:if>
</head>
<body>
<c:if test="${empty driver.id}">
    <c:url value="/addDriver" var="var"/>
</c:if>
<c:if test="${!empty driver.id}">
    <c:url value="/editDriver" var="var"/>
</c:if>
<form action = "${var}" method = "POST">
    <c:if test="${!empty driver.id}">
        <input type="hidden" name="id" value="${driver.id}">
    </c:if>
    <label for = "name">Name</label>
    <input type="text" name="name" id="name" required placeholder="Name"
           value="${!empty driver.name ? driver.name : ''}">
    <label for = "surname">Surname</label>
    <input type="text" name="surname" id="surname" required placeholder="Surname"
           value="${!empty driver.name ? driver.surname : ''}">>
    <label for = "phoneNumber">Phone</label>
    <input type="text" name="phoneNumber" id="phoneNumber" required placeholder="Phone number"
           value="${!empty driver.name ? driver.phoneNumber : ''}">>
<%--    <label for = "hours">Hours</label>
    <input type="text" name="hours" id="hours">--%>
    <label for = "currentCity">Current City</label>
    <input type="text" name="currentCity" id="currentCity" required placeholder="Name"
           value="${!empty driver.name ? driver.currentCity : ''}">>
<%--    <label for = "currentTruck">Truck</label>
    <input type="text" name="currentTruck" id="currentTruck">--%>
    <label for = "status">Status</label>
    <select name="status" id = "status">
        <option value="REST">REST</option>
        <option value="WORK">WORK</option>
        <option value="DRIVING">DRIVING</option>
    </select>
    <c:if test="${empty driver.name}">
        <input type="submit" value="add driver">
    </c:if>
    <c:if test="${!empty driver.name}">
        <input type="submit" value="edit driver">
    </c:if>

</form>
</body>
</html>
