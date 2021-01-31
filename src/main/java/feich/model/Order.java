package feich.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "delivery_order")
public class Order {

    enum OrderStatus {CREATED, DONE, PROGRESS}

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "status")
    @Enumerated(value = EnumType.STRING)
    private OrderStatus status;

    //todo change fetchType to lazy
    @OneToMany(mappedBy = "order", fetch = FetchType.EAGER)
    private Set<Cargo> cargoes = new HashSet<>();

    public Order() {
    }

    public Order(String status) {
        this.status = OrderStatus.CREATED;
    }

    public Long getId() {
        return id;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public Set<Cargo> getCargoes() {
        return cargoes;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public void setCargoes(Set<Cargo> cargoes) {
        this.cargoes = cargoes;
    }

    public void addCargo(Cargo cargo) {
        cargoes.add(cargo);
    }
}
