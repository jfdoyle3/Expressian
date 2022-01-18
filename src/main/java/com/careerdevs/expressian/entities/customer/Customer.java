package com.careerdevs.expressian.entities.customer;


import com.careerdevs.expressian.entities.auth.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;


@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String customerName;
    private String customerAddress;
    private String customerZip;
    private String customerState;
    private String customerCity;
    private String customerPayment;


    @OneToOne
    @JoinColumn(name="users_id", referencedColumnName = "id")
    @JsonIgnore
    private User user;


    public Customer(){}

    public Customer(String customerName, String customerAddress, String customerZip, String customerState, String customerCity, String customerPayment, User user) {
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerZip = customerZip;
        this.customerState = customerState;
        this.customerCity = customerCity;
        this.customerPayment = customerPayment;
        this.user = user;
    }

    public Customer(String customerName, User user) {
        this.customerName = customerName;
        this.user=user;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerZip() {
        return customerZip;
    }

    public void setCustomerZip(String customerZip) {
        this.customerZip = customerZip;
    }

    public String getCustomerState() {
        return customerState;
    }

    public void setCustomerState(String customerState) {
        this.customerState = customerState;
    }

    public String getCustomerCity() {
        return customerCity;
    }

    public void setCustomerCity(String customerCity) {
        this.customerCity = customerCity;
    }

    public String getCustomerPayment() {
        return customerPayment;
    }

    public void setCustomerPayment(String customerPayment) {
        this.customerPayment = customerPayment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
