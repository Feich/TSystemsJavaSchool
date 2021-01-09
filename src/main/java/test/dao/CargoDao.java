package test.dao;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;
import test.model.Cargo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@ComponentScan(basePackages = "test")
public class CargoDao {

    @PersistenceContext
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
    public List<Cargo> allCargoes() {
        return entityManager.createQuery("from Cargo").getResultList();
    }

    public void add(Cargo cargo) {
        entityManager.persist(cargo);
    }

    public void delete(Cargo cargo) {
        entityManager.remove(entityManager.contains(cargo) ? cargo : entityManager.merge(cargo));
    }

    public void edit(Cargo cargo) {
        entityManager.merge(cargo);
    }

    public Cargo getById(Long id) {
        return entityManager.find(Cargo.class, id);
    }
}