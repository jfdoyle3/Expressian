package com.careerdevs.expressian.entities.rental_agreement;


import com.careerdevs.expressian.entities.customer.Customer;
import com.careerdevs.expressian.entities.vehicle.Vehicle;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class RentalAgreement {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToMany
    private Set<Customer> customer;

    @ManyToMany
    private Set<Vehicle> vehicle;

    public RentalAgreement() {
    }


    public RentalAgreement(Long id, Set<Customer> customer, Set<Vehicle> vehicle) {
        this.id = id;
        this.customer = customer;
        this.vehicle = vehicle;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public Set<Customer> getCustomer() {
        return customer;
    }


    public void setCustomer(Set<Customer> customer) {
        this.customer = customer;
    }


    public Set<Vehicle> getVehicle() {
        return vehicle;
    }


    public void setVehicle(Set<Vehicle> vehicle) {
        this.vehicle = vehicle;
    }


}
