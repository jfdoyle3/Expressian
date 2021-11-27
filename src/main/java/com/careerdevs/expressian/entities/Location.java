package com.careerdevs.expressian.entities;

import javax.persistence.*;

@Entity
public class Location {

    @Id
    @GeneratedValue
    private Long id;
    private String location;
    @OneToOne
    @JoinColumn(name = "car_id")
    private Car car;
    @Column(name="rented")
    private Boolean isRented;

    public Location() {}

    public Location(String location, Car car, Boolean isRented) {
        this.location = location;
        this.car = car;
        this.isRented = isRented;
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

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Boolean getRented() {
        return isRented;
    }

    public void setRented(Boolean rented) {
        isRented = rented;
    }

}
