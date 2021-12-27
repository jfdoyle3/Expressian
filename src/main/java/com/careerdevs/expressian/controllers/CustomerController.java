package com.careerdevs.expressian.controllers;

import com.careerdevs.expressian.entities.customer.Customer;
import com.careerdevs.expressian.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    private CustomerRepository repository;

    @GetMapping
    public @ResponseBody
    List<Customer> getCustomer() {
        return repository.findAll();
    }

//    @GetMapping("/{name}")
//    public ResponseEntity<List<Customer>> getCustomerByName(@PathVariable String name) {
//        return new ResponseEntity<>(repository.findAllByName(name, Sort.by("name")), HttpStatus.OK);
//    }

    @GetMapping("/{id}")
    public @ResponseBody
    Customer getOneCustomer(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }


    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer newCustomer) {
        return new ResponseEntity<>(repository.save(newCustomer), HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public @ResponseBody
    Customer updateCustomer(@PathVariable Long id, @RequestBody Customer updates) {
        Customer customer = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        if (updates.getName() != null) customer.setName(updates.getName());

        return repository.save(customer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> destroyCar(@PathVariable Long id) {
        repository.deleteById(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }

}
