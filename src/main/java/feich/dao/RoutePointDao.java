package feich.dao;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;
import feich.model.RoutePoint;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@ComponentScan(basePackages = "feich")
public class RoutePointDao {
    @PersistenceContext
    private EntityManager entityManager;

    public List<RoutePoint> allObjects() {
        return entityManager.createQuery("from RoutePoint", RoutePoint.class).getResultList();
    }

    public void add(RoutePoint routePoint) {
        entityManager.persist(routePoint);
    }

    public void delete(RoutePoint routePoint) {
        entityManager.remove(entityManager.contains(routePoint) ? routePoint : entityManager.merge(routePoint));
    }

    public void edit(RoutePoint routePoint) {
        entityManager.merge(routePoint);
    }

    public RoutePoint getById(Long id) {
        return entityManager.find(RoutePoint.class, id);
    }

    public List<RoutePoint> routePointsInOrder(Long id) {
        TypedQuery<RoutePoint> query = entityManager.createQuery("select r from Cargo c, RoutePoint r where c.order.id = :id", RoutePoint.class);
        query.setParameter("id", id);
        return query.getResultList();
    }
}
