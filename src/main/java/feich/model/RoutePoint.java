package feich.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "route_point")
public class RoutePoint {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "city")
    private String city;

    @OneToMany
    @JoinColumn(name = "shipment_point_id")
    private Set<Cargo> cargoesForShipment = new HashSet<>();

    @OneToMany
    @JoinColumn(name = "discharge_point_id")
    private Set<Cargo> cargoesForDischarge = new HashSet<>();

    public RoutePoint() {}

    public Long getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public Set<Cargo> getCargoesForShipment() {
        return cargoesForShipment;
    }

    public Set<Cargo> getCargoesForDischarge() {
        return cargoesForDischarge;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCargoesForShipment(Set<Cargo> cargoesForShipment) {
        this.cargoesForShipment = cargoesForShipment;
    }

    public void setCargoesForDischarge(Set<Cargo> cargoesForDischarge) {
        this.cargoesForDischarge = cargoesForDischarge;
    }
}
