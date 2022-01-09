package com.careerdevs.expressian.entities.customer;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;


@Entity
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Customer {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private  String customerName;
    private  String email;
    private  String address;
    private  String city;
    private  String zip;


    public Customer(String customerName, String email, String address, String city, String zip) {
        this.customerName = customerName;
        this.email = email;
        this.address = address;
        this.city = city;
        this.zip = zip;
    }

}
