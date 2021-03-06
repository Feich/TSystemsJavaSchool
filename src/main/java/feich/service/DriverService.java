package feich.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import feich.dao.DriverDao;
import feich.model.Driver;

import java.util.List;

@Service
public class DriverService {

    private DriverDao driverDao;

    @Autowired
    public void setDriverDao(DriverDao driverDao) {
        this.driverDao = driverDao;
    }

    @Transactional(readOnly = true)
    public List<Driver> allDrivers() {
        return driverDao.allObjects();
    }

    @Transactional
    public void add(Driver driver) {
        driverDao.add(driver);
    }

    @Transactional
    public void delete(Long id) {
        driverDao.delete(driverDao.getById(id));
    }

    @Transactional
    public void  edit(Driver driver) {
        driverDao.edit(driver);
    }

    @Transactional
    public  Driver getById(Long id) {
        return driverDao.getById(id);
    }

    @Transactional(readOnly = true)
    public List<Driver> driversInOrder(Long id) {
        return driverDao.driversInOrder(id);
    }
}
