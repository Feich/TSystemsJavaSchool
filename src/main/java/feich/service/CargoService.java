package feich.service;

import feich.model.Cargo;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import feich.dao.CargoDao;

import java.util.List;
@Service
public class CargoService {

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

    public List<Cargo> cargoesForShipment(Long id) {
        return cargoDao.cargoesForShipment(id);
    }

    public List<Cargo> cargoesForDischarge(Long id) {
        return cargoDao.cargoesForDischarge(id);
    }

    public List<Cargo> cargoesInOrder(Long id) {
        return cargoDao.cargoesInOrder(id);
    }
}
