package com.careerdevs.expressian.entities.store;


import com.careerdevs.expressian.entities.vehicle.Vehicle;

import javax.persistence.*;
import java.util.Set;


@Entity
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String email;


    @OneToMany(fetch = FetchType.LAZY)
  //  @JsonIncludeProperties("developer")
    private Set<Vehicle> vehicle;

    public Store() {}

    public Store(String name, String address, String email) {
        this.name = name;
        this.address = address;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Vehicle> getVehicle() {
        return vehicle;
    }

    public void setVehicle(Set<Vehicle> vehicle) {
        this.vehicle = vehicle;
    }
}
