package com.careerdevs.expressian.entities;

public class Location {

    private Long id;
    private String location;
    private Car car;
    private Long quantity;

    public Location(String location, Car car, Long quantity) {
        this.location = location;
        this.car = car;
        this.quantity = quantity;
    }
}
