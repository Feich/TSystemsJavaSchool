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
    <c:if test="${empty order.cargoes}">
        <title>Add Order </title>
    </c:if>
    <c:if test="${!empty order.cargoes}">
        <title>Edit Order</title>
    </c:if>

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

        $(document).ready(function () {
            $('#cargoWithPoints').on("submit",function (e) {

                $.ajax({
                    type: "POST",
                    url: "/addCargoWithPoints/${order.id}",
                    data: $('#cargoWithPoints').serialize(),
                    alert: function () {
                        alert("Cargo saved!");
                    }
                });
                e.preventDefault();
            });
            return false;
        });

/*        $(document).ready(function () {
            $("#cargoWithPoints").submit(function(e) {
                e.preventDefault();
                alert("Cargo Saved!");
            });
            return false;
        });*/
    </script>

</head>
<body>

<h2>Cargoes</h2>

<form action = "/addCargoWithPoints/${order.id}" method = "POST" class="cargoForm" id = "cargoWithPoints">
    <p class="addCargoForm">
        <label for = "name">Name</label>
        <input type="text" name="cargo.name" id="name" required placeholder="Name">
        <label for = "weight">Weight</label>
        <input type="text" name="cargo.weight" id="weight" required placeholder="Weight">
        <label for = "shipmentPoint.city">Shipment Point</label>
        <input type="text" name="shipmentPoint.city" id="shipmentPoint.city" required placeholder="Shipment Point">
        <label for = "dischargePoint.city">Discharge Point</label>
        <input type="text" name="dischargePoint.city" id="dischargePoint.city" required placeholder="Discharge Point">
        <label for = "status">Status</label>
        <select name="cargo.status" id = "status">
            <option value="PREPARED">PREPARED</option>
            <option value="SHIPPED">SHIPPED</option>
            <option value="DELIVERED">DELIVERED</option>
        </select>
        <input type="hidden" name="order" value="${order.id}">
        <input type="submit" value="Save cargo">
    </p>
    <button type="button" class="addCargo" id="submitCargo">Add Cargo</button>
</form>

<c:if test="${empty order.cargoes}">
    <c:url value="/addOrder" var="var"/>
</c:if>
<c:if test="${!empty order.cargoes}">
    <c:url value="/editOrder" var="var"/>
</c:if>

<form action = "${var}" method = "POST">
    <c:if test="${!empty order.cargoes}">
        <input type="hidden" name="id" value="${order.id}">
    </c:if>
    <label for = "order.status">Status</label>
    <select name="status" id = "order.status">
        <option value="CREATED">CREATED</option>
        <option value="PROGRESS">IN PROGRESS</option>
        <option value="DONE">DONE</option>
    </select>
    <c:if test="${empty order.cargoes}">
        <input type="submit" value="add order">
    </c:if>
    <c:if test="${!empty order.cargoes}">
        <input type="submit" value="edit order">
    </c:if>
</form>
</body>
</html>
