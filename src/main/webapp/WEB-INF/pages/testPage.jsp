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
    <c:if test="${empty order.number}">
        <title>Add Order </title>
    </c:if>
    <c:if test="${!empty order.number}">
        <title>Edit Order</title>
    </c:if>
</head>
<body>

<h2>Cargoes</h2>

<form action = "/addCargo" method = "POST" class="cargoForm">
    <p class="addCargoForm">
        <label for = "name">Name</label>
        <input type="text" name="name" id="name" placeholder="Name">
        <label for = "weight">Weight</label>
        <input type="text" name="weight" id="weight" placeholder="Weight">
        <label for = "shipmentCity">Shipment Point</label>
        <input type="text" name="shipmentCity" id="shipmentCity" required placeholder="Shipment Point">
        <label for = "dischargeCity">Discharge Point</label>
        <input type="text" name="dischargeCity" id="dischargeCity" required placeholder="Discharge Point">
        <label for = "cargoStatus">Status</label>
        <select name="status" id = "cargoStatus">
            <option selected disabled value="0">Select Status</option>
            <option value="PREPARED">PREPARED</option>
            <option value="SHIPPED">SHIPPED</option>
            <option value="DELIVERED">DELIVERED</option>
        </select>
        <input type="submit" value="add cargo">
    </p>
    <button type="button" class="addCargo">Add Cargo</button>
</form>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script type="text/javascript">
    $(document).ready(function(){
        $( ".addCargo" ).click(function(){
            var $clone = $( ".addCargoForm" ).first().clone();
            $clone.append( "<button type='button' class='remove-row'>Remove Cargo</button>" );
            $clone.insertBefore( ".addCargo" );
        });

        $( ".cargoForm" ).on("click", ".remove-row", function(){
            $(this).parent().remove();
        });
    });
</script>


<c:if test="${empty order.id}">
    <c:url value="/addOrder" var="var"/>
</c:if>
<c:if test="${!empty order.id}">
    <c:url value="/editOrder" var="var"/>
</c:if>

<form action = "${var}" method = "POST">
    <c:if test="${!empty order.id}">
        <input type="hidden" name="id" value="${order.id}">
    </c:if>
    <select name="status" id = "status">
        <option selected disabled value="0">Select Status</option>
        <option value="CREATED">CREATED</option>
        <option value="PROGRESS">IN PROGRESS</option>
        <option value="DONE">DONE</option>
    </select>
    <c:if test="${empty order.number}">
        <input type="submit" value="add order">
    </c:if>
    <c:if test="${!empty order.number}">
        <input type="submit" value="edit order">
    </c:if>
</form>
</body>
</html>
