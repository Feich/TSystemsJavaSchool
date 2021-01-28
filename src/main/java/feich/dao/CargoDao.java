package feich.dao;

import feich.model.Cargo;
import feich.model.RoutePoint;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@ComponentScan(basePackages = "feich")
public class CargoDao {
    //todo create interfaces and abstract classes
    @PersistenceContext
    private EntityManager entityManager;

    public List<Cargo> allObjects() {
        return entityManager.createQuery("from Cargo", Cargo.class).getResultList();
    }

    public void add(Cargo cargo) {
        entityManager.persist(cargo);
    }

/*    public void add(Cargo cargo, Long orderId) {
        entityManager.persist(cargo);
        *//*entityManager.flush();
        entityManager.createQuery("update Cargo.order o set order_id = :orderId");*//*
    }*/

    public void delete(Cargo cargo) {
        entityManager.remove(cargo);
    }

    public void edit(Cargo cargo) {
        entityManager.merge(cargo);
    }

    public Cargo getById(Long id) {
        return entityManager.find(Cargo.class, id);
    }

    public List<Cargo> cargoesForTruck(Long id) {
        TypedQuery<Cargo> query = entityManager.createQuery("from Cargo c where c.truck.id = :truckId", Cargo.class);
        query.setParameter("truckId", id);
        return query.getResultList();
    }

    public List<Cargo> cargoesForShipment(Long id) {
        TypedQuery<Cargo> query = entityManager.createQuery("from Cargo c where c.shipmentPoint.id = :id", Cargo.class);
        query.setParameter("id", id);
        return query.getResultList();
    }

    public List<Cargo> cargoesForDischarge(Long id) {
        TypedQuery<Cargo> query = entityManager.createQuery("from Cargo c where c.dischargePoint.id = :id", Cargo.class);
        query.setParameter("id", id);
        return query.getResultList();
    }

    public List<Cargo> cargoesInOrder(Long id) {
        TypedQuery<Cargo> query = entityManager.createQuery("from Cargo c where c.order.id = :id", Cargo.class);
        query.setParameter("id", id);
        return query.getResultList();
    }

}