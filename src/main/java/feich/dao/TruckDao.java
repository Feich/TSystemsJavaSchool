package feich.dao;

import feich.model.Truck;
import feich.service.exception.TruckNumberException;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@ComponentScan(basePackages = "feich")
public class TruckDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Truck> allObjects() {
        return entityManager.createQuery("from Truck", Truck.class).getResultList();
    }

    public void add(Truck truck) throws TruckNumberException {
        entityManager.persist(truck);
    }

    public void delete(Truck truck) {
        entityManager.remove(truck);
    }

    public void edit(Truck truck) {
        entityManager.merge(truck);
    }

    public Truck getById(Long id) {
        return entityManager.find(Truck.class, id);
    }

    public List<Truck> truckInOrder(Long id) {
        TypedQuery<Truck> query = entityManager.createQuery("select t from Truck t, Cargo c where c.order.id = :id", Truck.class);
        query.setParameter("id", id);
        return query.getResultList();
    }
}
