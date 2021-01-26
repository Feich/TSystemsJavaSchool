package feich.service;

import feich.dao.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import feich.model.Order;

import java.util.List;

@Service
public class OrderService {

    private OrderDao orderDao;

    @Autowired
    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Transactional(readOnly = true)
    public List<Order> allOrders() {
        return orderDao.allObjects();
    }

    @Transactional
    public void add(Order order) {
        orderDao.add(order);
    }

    @Transactional
    public void delete(Order order) {
        orderDao.delete(order);
    }

    @Transactional
    public void  edit(Order order) {
        orderDao.edit(order);
    }

    @Transactional
    public  Order getById(Long id) {
        return orderDao.getById(id);
    }

    public List<Order> orderByRoutePoint(Long id) {
        return orderDao.orderByRoutePoint(id);
    }
}
