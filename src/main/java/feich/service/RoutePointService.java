package feich.service;

import feich.dao.RoutePointDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import feich.model.RoutePoint;

import java.util.List;

@Service
public class RoutePointService {

    private RoutePointDao routePointDao;

    @Autowired
    public void setRoutePointDao(RoutePointDao routePointDao) {
        this.routePointDao = routePointDao;
    }

    @Transactional(readOnly = true)
    public List<RoutePoint> allRoutePoints() {
        return routePointDao.allObjects();
    }

    @Transactional
    public void add(RoutePoint routePoint) {
        routePointDao.add(routePoint);
    }

    @Transactional
    public void delete(RoutePoint routePoint) {
        routePointDao.delete(routePoint);
    }

    @Transactional
    public void  edit(RoutePoint routePoint) {
        routePointDao.edit(routePoint);
    }

    @Transactional(readOnly = true)
    public  RoutePoint getById(Long id) {
        return routePointDao.getById(id);
    }

    @Transactional(readOnly = true)
    public List<RoutePoint> routePointsInOrder(Long id) {
        return routePointDao.routePointsInOrder(id);
    }
}
