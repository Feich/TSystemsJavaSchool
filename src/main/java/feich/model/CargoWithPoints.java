package feich.model;


public class CargoWithPoints {
    private Cargo cargo;
    private RoutePoint shipmentPoint;
    private RoutePoint dischargePoint;
    private Order order;

    public CargoWithPoints() {
    }

    public Cargo getCargo() {
        return cargo;
    }

    public RoutePoint getShipmentPoint() {
        return shipmentPoint;
    }

    public RoutePoint getDischargePoint() {
        return dischargePoint;
    }

    public Order getOrder() {
        return order;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public void setShipmentPoint(RoutePoint shipmentPoint) {
        this.shipmentPoint = shipmentPoint;
    }

    public void setDischargePoint(RoutePoint dischargePoint) {
        this.dischargePoint = dischargePoint;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
