package feich.dao;

import feich.model.Driver;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@ComponentScan(basePackages = "feich")
public class DriverDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Driver> allObjects() {
        return entityManager.createQuery("from Driver", Driver.class).getResultList();
    }

    public void add(Driver driver) {
        entityManager.persist(driver);
    }

    public void delete(Driver driver) {
        entityManager.remove(driver);
    }

    public void edit(Driver driver) {
        entityManager.merge(driver);
    }

    public Driver getById(Long id) {
        return entityManager.find(Driver.class, id);
    }

    public List<Driver> driversInOrder(Long id) {
        TypedQuery<Driver> query = entityManager.createQuery("select d from Truck t, Driver d, Cargo c where c.order.id = :orderId", Driver.class);
        query.setParameter("orderId", id);
        return query.getResultList();
    }
}