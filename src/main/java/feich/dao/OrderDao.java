package feich.dao;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;
import feich.model.Order;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@ComponentScan(basePackages = "feich")
public class OrderDao {
    
    @PersistenceContext
    private EntityManager entityManager;

    public List<Order> allObjects() {
        return entityManager.createQuery("from Order", Order.class).getResultList();
    }

    public void add(Order order) {
        entityManager.persist(order);
    }

    public void delete(Order order) {
        entityManager.remove(entityManager.contains(order) ? order : entityManager.merge(order));
    }

    public void edit(Order order) {
        entityManager.merge(order);
    }

    public Order getById(Long id) {
        return entityManager.find(Order.class, id);
    }

    public List<Order> orderByRoutePoint(Long id) {
        TypedQuery<Order> query = entityManager.createQuery("from Order o, Cargo c where c.shipmentPoint.id = :id or c.dischargePoint.id = :id", Order.class);
        query.setParameter("id", id);
        return query.getResultList();
    }
}
