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
    public Order add(Order order) {
        return orderDao.add(order);
    }

    @Transactional
    public void delete(Long id) {
        orderDao.delete(orderDao.getById(id));
    }

    @Transactional
    public void  edit(Order order) {
        orderDao.edit(order);
    }

    @Transactional
    public  Order getById(Long id) {
        return orderDao.getById(id);
    }

    @Transactional(readOnly = true)
    public List<Order> orderByRoutePoint(Long id) {
        return orderDao.orderByRoutePoint(id);
    }
}
