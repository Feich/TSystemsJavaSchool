package test.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import test.model.Cargo;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
@Repository
@ComponentScan(basePackages = "test")
public class CargoDao {
    @PersistenceContext
    private EntityManager entityManager;

    /*@Autowired
    public void setEntityManagerFactory(EntityManager entityManager) {
        this.entityManager = entityManager;
    }*/

    @SuppressWarnings("unchecked")
    public List<Cargo> allCargoes() {
        entityManager.getTransaction().begin();
        List<Cargo> cargoes = entityManager.createQuery("from Cargo").getResultList();
//        entityManager.close();
        return cargoes;
    }

    public void add(Cargo cargo) {
        entityManager.getTransaction().begin();
        entityManager.persist(cargo);
        entityManager.getTransaction().commit();
    }

    public void delete(Cargo cargo) {
        entityManager.getTransaction().begin();
        entityManager.remove(cargo);
        entityManager.getTransaction().commit();
    }

    public void edit(Cargo cargo) {
        entityManager.getTransaction().begin();
        entityManager.merge(cargo);
        entityManager.getTransaction().commit();
    }

    public Cargo getById(Long id) {
        entityManager.getTransaction().begin();
        return entityManager.find(Cargo.class, id);
    }
}