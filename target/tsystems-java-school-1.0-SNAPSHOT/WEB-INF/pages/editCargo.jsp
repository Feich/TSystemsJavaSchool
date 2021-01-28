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
<form action = "${var}" method = "POST" name="cargoWithPoints">
    <c:if test="${!empty cargo.id}">
        <input type="hidden" name="cargo.id" value="${cargo.id}">
    </c:if>
    <label for = "cargo.name">Name</label>
    <input type="text" name="cargo.name" id="cargo.name" required placeholder="Name"
           value="${!empty cargo.name ? cargo.name : ''}">
    <label for = "cargo.weight">Weight</label>
    <input type="text" name="cargo.weight" id="cargo.weight" required placeholder="Weight, ton"
           value="${!empty cargo.name ? cargo.weight : ''}">
    <input type="hidden" name="dischargePoint.city" value=${cargo.dischargePoint.city}>
    <input type="hidden" name="shipmentPoint.city" value=${cargo.shipmentPoint.city}>
    <input type="hidden" name="order.id" value=${cargo.order.id}>
    <%-- todo add selects --%>
    <%--<label for = "order">Order</label>
    <input type="text" name="order" id="order" >--%>
<%--    <label for = "shipmentPoint">Shipment Point</label>
    <select name="shipmentPoint" id = "shipmentPoint">
        <c:forEach var="shipmentPoint" items="${routePoints}">
            <option value="1" ${!empty currentShipmentPoint ?
             'selected="selected"' : ''}> ${shipmentPoint.city}</option>
        </c:forEach>
    </select>
    <label for = "dischargePoint">Discharge Point</label>
    <select name="dischargePoint" id = "dischargePoint">
        <c:forEach var="dischargePoint" items="${routePoints}">
            <option value="${dischargePoint.city}" ${currentDischargePoint == dischargePoint ?
                    'selected="selected"' : ''}> ${dischargePoint.city}</option>
        </c:forEach>
    </select>--%>
<%--    <input type="hidden" id="dischargePoint" name="dischargePoint" value=${cargo.dischargePoint}>
    <input type="hidden" id="shipmentPoint" name="shipmentPoint" value=${cargo.shipmentPoint}>--%>
<%--    <label for = "dischargePoint.city">Discharge Point</label>
    <input type="text" name="dischargePoint.city" id="dischargePoint.city" required placeholder="Discharge Point"
           value="${!empty cargo.name ? cargo.dischargePoint.city : ''}">
    <label for = "shipmentPoint.city">Shipment Point</label>
    <input type="text" name="shipmentPoint.city" id="shipmentPoint.city" required placeholder="Shipment Point"
           value="${!empty cargo.name ? cargo.shipmentPoint.city : ''}">--%>
    <label for = "cargo.status">Status</label>
    <select name="cargo.status" id = "cargo.status">
        <option value="PREPARED">PREPARED</option>
        <option value="SHIPPED">SHIPPED</option>
        <option value="DELIVERED">DELIVERED</option>
    </select>
    <c:if test="${empty cargo.name}">
        <input type="submit" value="add cargo">
    </c:if>
    <c:if test="${!empty cargo.name}">
        <input type="submit" value="edit cargo">
    </c:if>

</form>
</body>
</html>
