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

    @OneToOne
    @JoinColumn(name="users_id", referencedColumnName = "id")
    @JsonIgnore
    private User user;


    public Customer(){}

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
