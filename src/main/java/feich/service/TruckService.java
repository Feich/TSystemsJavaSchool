package feich.service;

import feich.dao.TruckDao;
import feich.service.exception.TruckNumberException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import feich.model.Truck;

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
        return truckDao.allObjects();
    }

    @Transactional
    public void add(Truck truck) throws TruckNumberException {
        truckDao.add(truck);
    }

    @Transactional
    public void delete(Long id) {
        truckDao.delete(truckDao.getById(id));
    }

    @Transactional
    public void  edit(Truck truck) {
        truckDao.edit(truck);
    }

    @Transactional
    public  Truck getById(Long id) {
        return truckDao.getById(id);
    }

    @Transactional(readOnly = true)
    public List<Truck> truckInOrder(Long id) {
        return truckDao.truckInOrder(id);
    }
}
