package com.careerdevs.expressian.entities.location;


import com.careerdevs.expressian.entities.vehicle.Vehicle;

import javax.persistence.*;

@Entity
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String location;

    @Column(name="rented")
    private Boolean isRented;

    @OneToOne
    private Vehicle vehicle;

    public Location() {}

    public Location(String location, Boolean isRented,Vehicle vehicle) {
        this.location = location;
        this.isRented = isRented;
        this.vehicle=vehicle;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


    public Boolean getRented() {
        return isRented;
    }

    public void setRented(Boolean rented) {
        isRented = rented;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
