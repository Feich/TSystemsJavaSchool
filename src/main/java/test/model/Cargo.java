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
    private float weight;

    @Column(name = "status")
    @Enumerated(value = EnumType.STRING)
    private CargoStatus status;

    public Cargo() {}

/*    public Cargo(String name, double weight, String status) {
        this.name = name;
        this.weight = (float) weight;
        this.status = status;
    }*/
/*    public Cargo(Long id, String name, float weight, String status) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.status = status;
    }*/

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public void setStatus(String status) {
        this.status = CargoStatus.valueOf(status);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getWeight() {
        return weight;
    }

    public String getStatus() {
        return String.valueOf(status);
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
