package feich.model;

import javax.persistence.*;
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

    public Long getId() {
        return id;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

}
