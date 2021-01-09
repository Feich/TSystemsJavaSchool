package test.model;

import javax.persistence.*;

@Entity
@Table(name = "cargo")
public class Cargo {

    enum CargoStatus {PREPARED, SHIPPED, DELIVERED}

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
