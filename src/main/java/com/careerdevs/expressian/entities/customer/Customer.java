//package com.careerdevs.expressian.entities;
//
//import javax.persistence.*;
//import java.util.Set;
//
//@Entity
//public class Customer {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private String name;
//    private String carPurchased;
//
//    @ManyToMany
//    @JoinTable(
//            name="store_customer",
//            joinColumns=@JoinColumn(name="customer_id"),
//            inverseJoinColumns = @JoinColumn(name="store_id")
//    )
//    private Set<Store> stores;
//
//
//    public Customer(){}
//
//    public Customer(String name, String carPurchased) {
//        this.name = name;
//        this.carPurchased = carPurchased;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getCarPurchased() {
//        return carPurchased;
//    }
//    public void setCarPurchased(String carPurchased) {
//        this.carPurchased = carPurchased;
//    }
//
//    public Set<Store> getStores() {
//        return stores;
//    }
//}
