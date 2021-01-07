package test.service;

import org.springframework.transaction.annotation.Transactional;
import test.model.Cargo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.dao.CargoDao;

import java.util.List;
@Service
public class CargoService {

    private CargoDao cargoDao;

    @Autowired
    public void setCargoDao(CargoDao cargoDao) {
        this.cargoDao = cargoDao;
    }

    @Transactional
    public List<Cargo> allCargoes() {
        return cargoDao.allCargoes();
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
}
