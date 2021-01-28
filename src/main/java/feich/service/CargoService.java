package feich.service;

import feich.dao.OrderDao;
import feich.model.Cargo;
import feich.model.CargoWithPoints;
import feich.model.Order;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import feich.dao.CargoDao;

import java.util.List;
@Service
public class CargoService {

    private OrderDao orderDao;

    @Autowired
    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }
    private CargoDao cargoDao;

    @Autowired
    public void setCargoDao(CargoDao cargoDao) {
        this.cargoDao = cargoDao;
    }

    @Transactional(readOnly = true)
    public List<Cargo> allCargoes() {
        return cargoDao.allObjects();
    }

    @Transactional
    public void add(Cargo cargo) {
        cargoDao.add(cargo);
    }

/*
    @Transactional
    public void add(Cargo cargo, Long orderId) {
        cargoDao.add(cargo, orderId);
    }
*/

    @Transactional
    public void delete(Cargo cargo) {
        cargoDao.delete(cargo);
    }

    @Transactional
    public void  edit(Cargo cargo) {
        cargoDao.edit(cargo);
    }

    @Transactional
    public  Cargo getById(Long id) {
        return cargoDao.getById(id);
    }

    @Transactional(readOnly = true)
    public List<Cargo> cargoesForTruck(Long id) {
        return  cargoDao.cargoesForTruck(id);
    }

    @Transactional(readOnly = true)
    public List<Cargo> cargoesForShipment(Long id) {
        return cargoDao.cargoesForShipment(id);
    }

    @Transactional(readOnly = true)
    public List<Cargo> cargoesForDischarge(Long id) {
        return cargoDao.cargoesForDischarge(id);
    }

    @Transactional(readOnly = true)
    public List<Cargo> cargoesInOrder(Long id) {
        return cargoDao.cargoesInOrder(id);
    }

    @Transactional
    public void saveCargo(CargoWithPoints cargoWithPoints, Long orderId) {
        Cargo cargo = cargoWithPoints.getCargo();
        cargo.setShipmentPoint(cargoWithPoints.getShipmentPoint());
        cargo.setDischargePoint(cargoWithPoints.getDischargePoint());
        Order order = orderDao.getById(orderId);
        cargo.setOrder(order);
        cargoDao.add(cargo);
    }
}
