package com.careerdevs.expressian.entities;

import javax.persistence.*;


//TODO: MANY Cars TO ONE Store
@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand;
    private String name;
    private String type;
    private Integer year;
    @OneToOne
    @JoinColumn(name = "location_id")
    private Location location;

    public Car(){}

    public Car(String brand, String name, String type, Integer year, Location location) {
        this.brand = brand;
        this.name = name;
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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
