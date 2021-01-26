package feich.model;

import javax.persistence.*;

@Entity
@Table(name = "Driver")
public class Driver {

    enum DriverStatus {REST, WORK, DRIVING}

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "hours")
    private int hours;

    @Column(name = "current_city")
    private String currentCity;

    @Column(name = "status")
    @Enumerated(value = EnumType.STRING)
    private DriverStatus status;

    @ManyToOne
    @JoinColumn(name = "current_truck_id")
    private Truck truck;

    public Driver() {}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getHours() {
        return hours;
    }

    public String getCurrentCity() {
        return currentCity;
    }

    public DriverStatus getStatus() {
        return status;
    }

    public Truck getTruck() {
        return truck;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public void setCurrentCity(String currentCity) {
        this.currentCity = currentCity;
    }

    public void setStatus(DriverStatus status) {
        this.status = status;
    }

    public void setTruck(Truck truck) {
        this.truck = truck;
    }
}
