package com.careerdevs.expressian.entities;


import javax.persistence.*;
import java.util.Set;

//TODO: MANY Cars TO ONE Store
@Entity
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String location;
    private String email;

    @ManyToMany
    @JoinTable(
            name="store_customer",
            joinColumns=@JoinColumn(name="store_id"),
            inverseJoinColumns = @JoinColumn(name="customer_id")
    )
    private Set<Customer> customers;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    public Store() {}

    public Store(String name, String location, String email) {
        this.name = name;
        this.location = location;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }
}
