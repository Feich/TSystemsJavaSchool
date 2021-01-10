package test.service;

import org.springframework.transaction.annotation.Transactional;
import test.dao.TruckDao;
import test.model.Truck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TruckService {

    private TruckDao truckDao;

    @Autowired
    public void setTruckDao(TruckDao truckDao) {
        this.truckDao = truckDao;
    }

    @Transactional(readOnly = true)
    public List<Truck> allTrucks() {
        return truckDao.allTrucks();
    }

    @Transactional
    public void add(Truck truck) {
        truckDao.add(truck);
    }

    @Transactional
    public void delete(Truck truck) {
        truckDao.delete(truck);
    }

    @Transactional
    public void  edit(Truck truck) {
        truckDao.edit(truck);
    }

    @Transactional
    public  Truck getById(Long id) {
        return truckDao.getById(id);
    }
}
