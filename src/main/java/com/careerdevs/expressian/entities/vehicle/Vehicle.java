package com.careerdevs.expressian.entities.vehicle;
import com.careerdevs.expressian.entities.location.Location;

import javax.persistence.*;


//TODO: MANY Cars TO ONE Store
@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String make;
    private String model;
    private String type;
    private Integer year;
    @OneToOne
    @JoinColumn(name = "location_id")
    private Location location;

    public Vehicle(){}

    public Vehicle(String make, String model, String type, Integer year, Location location) {
        this.make = make;
        this.model = model;
        this.type = type;
        this.year = year;
        this.location = location;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
