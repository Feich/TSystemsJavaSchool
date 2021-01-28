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
    <c:if test="${empty order.number}">
        <title>Add Order </title>
    </c:if>
    <c:if test="${!empty order.number}">
        <title>Edit Order</title>
    </c:if>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <script src="http://malsup.github.com/jquery.form.js"></script>
    <script type="text/javascript">
        $(document).ready(function(){
            $( ".addCargo" ).click(function(){
                var $clone = $( ".addCargoForm" ).first().clone();
                $clone.append( "<button type='button' class='remove-row'>Remove Cargo</button>" );
                $clone.insertBefore( ".addCargo" );
            });

            $( ".addCargoClass" ).on("click", ".remove-row", function(){
                $(this).parent().remove();
            });
        });

        /*        $(document).ready(function () {
                    $(".submitAll").click(function () {
                        $(".cargoForm").submit();
                        $(document).ready(function () {
                            $(".addShipmentPoint").submit();
                            $(document).ready(function () {
                                $(".addDischargePoint").submit();
                            })
                        })
                    });
                });*/
        function validate() {
            var fields = [document.cargoForm.name, document.cargoForm.weight, document.cargoForm.status,
                document.shipmentCity.city, document.dischargeCity.city];
            fields.forEach(element => function () {
                alert("checking " + element.value)
                if (element.value.length == 0) {
                    alert("Please, fill all fields");
                    // document.getElementById(element).innerHTML="*Please, fill this field";
                    return false;
                }
            })
            if ($('#status').selectedIndex == 0) {
                document.getElementById($('#status')).innerHTML="*Please, fill this field";
                return false;
            }
            return true;
        }

        $(document).ready(function () {
            $('#submitAll').click(function () {
                if (validate()) {
                    $('#addShipmentPoint').ajaxSubmit();
                    alert("shipment point added");
                    $('#addDischargePoint').ajaxSubmit();
                    alert("discharge point added");
                    $('#cargoForm').ajaxSubmit();
                    alert("cargo added");
                }
            });
            return false;
        });

    </script>

</head>
<body>

<h2>Cargoes</h2>
<div class="addCargoClass">
    <div class="addCargoForm">
        <br>
        <form action = "/addCargo" method = "POST" class="cargoForm" id="cargoForm" name="cargoForm">
            <label for = "name">Name</label>
            <input type="text" name="name" id="name" placeholder="Name">
            <label for = "weight">Weight</label>
            <input type="text" name="weight" id="weight" placeholder="Weight">
            <label for = "status">Status</label>
            <select name="status" id = "status">
                <option selected disabled value="0">Select Status</option>
                <option value="PREPARED">PREPARED</option>
                <option value="SHIPPED">SHIPPED</option>
                <option value="DELIVERED">DELIVERED</option>
            </select>
        </form>
        <form action="/addRoutePoint" method = "POST" class="addShipmentPoint" id="addShipmentPoint" name="shipmentCity">
            <label for = "shipmentCity">Shipment Point</label>
            <input type="text" name="city" id="shipmentCity" required="required" placeholder="Shipment Point">
        </form>
        <form action="/addRoutePoint" method = "POST" class="addDischargePoint" id="addDischargePoint" name="dischargeCity">
            <label for = "dischargeCity">Discharge Point</label>
            <input type="text" name="city" id="dischargeCity" required="required" placeholder="Discharge Point">
        </form>
        <input type="submit" value="add cargo" class="submitAll" id="submitAll">
    </div>
    <button type="button" class="addCargo">+ Cargo</button>
</div>

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
    <label for = "OrderStatus">Status</label>
    <select name="status" id = "Orderstatus">
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