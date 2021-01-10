package test.dao;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;
import test.model.Cargo;
import test.model.Truck;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@ComponentScan(basePackages = "test")
public class TruckDao {

    @PersistenceContext
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
    public List<Truck> allTrucks() {
        return entityManager.createQuery("from Truck").getResultList();
    }

    public void add(Truck truck) {
        entityManager.persist(truck);
    }

    public void delete(Truck truck) {
        entityManager.remove(entityManager.contains(truck) ? truck : entityManager.merge(truck));
    }

    public void edit(Truck truck) {
        entityManager.merge(truck);
    }

    public Truck getById(Long id) {
        return entityManager.find(Truck.class, id);
    }
}
