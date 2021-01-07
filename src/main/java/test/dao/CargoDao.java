package test.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import test.model.Cargo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
@Repository("dao")
public class CargoDao {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @SuppressWarnings("unchecked")
    public List<Cargo> allCargoes() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Cargo").list();
    }

    public void add(Cargo cargo) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(cargo);
    }

    public void delete(Cargo cargo) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(cargo);
    }

    public void edit(Cargo cargo) {
        Session session = sessionFactory.getCurrentSession();
        session.update(cargo);
    }

    public Cargo getById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Cargo.class, id);
    }
}