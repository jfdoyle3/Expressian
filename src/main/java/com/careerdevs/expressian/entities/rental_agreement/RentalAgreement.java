package com.careerdevs.expressian.entities.rental_agreement;

import com.careerdevs.expressian.entities.customer.Customer;
import com.careerdevs.expressian.entities.vehicle.Vehicle;

import java.util.Set;

import javax.persistence.*;

@Entity
public class RentalAgreement {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private Vehicle vehicle;

    public RentalAgreement() {}


    public RentalAgreement(Long id, Customer customer, Vehicle vehicle) {
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


    public Customer getCustomer() {
        return customer;
    }


    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


    public Vehicle getVehicle() {
        return vehicle;
    }


    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }


}