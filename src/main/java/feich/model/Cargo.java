package feich.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "cargo")
public class Cargo {

    enum CargoStatus {PREPARED, SHIPPED, DELIVERED}

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy= GenerationType.SEQUENCE,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "weight")
    private double weight;

    @Column(name = "status")
    @Enumerated(value = EnumType.STRING)
    private CargoStatus status;

    @ManyToOne
    @JoinColumn(name = "truck_id")
    private Truck truck;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "shipment_point_id")
    private RoutePoint shipmentPoint;

    @ManyToOne
    @JoinColumn(name = "discharge_point_id")
    private RoutePoint dischargePoint;

    public Cargo() {}

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setStatus(CargoStatus status) {
        this.status = status;
    }

    public void setTruck(Truck truck) {
        this.truck = truck;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void setShipmentPoint(RoutePoint shipmentPoint) {
        shipmentPoint.getCargoesForShipment().add(this);
        this.shipmentPoint = shipmentPoint;
    }

    public void setDischargePoint(RoutePoint dischargePoint) {
        dischargePoint.getCargoesForDischarge().add(this);
        this.dischargePoint = dischargePoint;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public CargoStatus getStatus() {
        return status;
    }

    public Truck getTruck() {
        return truck;
    }

    public Order getOrder() {
        return order;
    }

    public RoutePoint getShipmentPoint() {
        return shipmentPoint;
    }

    public RoutePoint getDischargePoint() {
        return dischargePoint;
    }

    @Override
    public String toString() {
        return "Cargo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", status='" + status + '\'' +
                '}';
    }
}
