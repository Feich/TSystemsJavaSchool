package test.service;

import model.Cargo;
import test.dao.CargoDao;

import java.util.List;

public class CargoService {
    private CargoDao cargoDao = new CargoDao();

    public List<Cargo> allCargoes() {
        return cargoDao.allCargoes();
    }

    public void add(Cargo cargo) {
        cargoDao.add(cargo);
    }

    public void delete(Cargo cargo) {
        CargoDao.delete(cargo);
    }
}
