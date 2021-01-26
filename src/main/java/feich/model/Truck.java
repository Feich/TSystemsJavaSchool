package feich.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "truck")
public class Truck {

    enum TruckStatus {OK, DEFECTIVE}

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "number")
    private String number;

    @Column(name = "driver_shift_size")
    private int driverShiftSize;

    @Column(name = "capacity")
    private double capacity;

    @Column(name = "current_city")
    private String currentCity;

    @Column(name = "status")
    @Enumerated(value = EnumType.STRING)
    private TruckStatus status;

    @OneToMany(mappedBy = "truck")
    private Set<Cargo> cargoes;

    @OneToMany(mappedBy = "truck")
    private Set<Driver> drivers;

    public Truck() {}

    public Long getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public int getDriverShiftSize() {
        return driverShiftSize;
    }

    public double getCapacity() {
        return capacity;
    }

    public String getCurrentCity() {
        return currentCity;
    }

    public TruckStatus getStatus() {
        return status;
    }

    public Set<Cargo> getCargoes() {
        return cargoes;
    }

    public Set<Driver> getDrivers() {
        return drivers;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setDriverShiftSize(int driverShiftSize) {
        this.driverShiftSize = driverShiftSize;
    }

    public void setStatus(TruckStatus status) {
        this.status = status;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public void setCurrentCity(String currentCity) {
        this.currentCity = currentCity;
    }

    public void setCargoes(Set<Cargo> cargoes) {
        this.cargoes = cargoes;
    }

    public void setDrivers(Set<Driver> drivers) {
        this.drivers = drivers;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "id=" + id +
                ", number=" + number + '\'' +
                ", capacity=" + capacity +
                ", driver_shift_size=" + driverShiftSize +
                ", status=" + status + '\'' +
                '}';
    }
}
