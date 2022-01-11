package com.careerdevs.expressian.controllers;

import com.careerdevs.expressian.entities.auth.User;
import com.careerdevs.expressian.entities.customer.Customer;
import com.careerdevs.expressian.repositories.CustomerRepository;
import com.careerdevs.expressian.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository repository;

    @Autowired
    private UserService userService;


    @GetMapping
    @ResponseBody
    public List<Customer> getCustomer() {
        return repository.findAll();
    }

//    @GetMapping("/{name}")
//    public ResponseEntity<List<Customer>> getCustomerByName(@PathVariable String name) {
//        return new ResponseEntity<>(repository.findAllByName(name, Sort.by("name")), HttpStatus.OK);
//    }

    @GetMapping("/{id}")
    @ResponseBody
    public Customer getOneCustomer(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/self")
    public @ResponseBody Customer getSelf() {
        User currentUser = userService.getCurrentUser();

        if (currentUser == null) {
            return null;
        }
        return repository.findByUser_id(currentUser.getId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }


    @PostMapping("/create")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer newCustomer) {
        User currentUser=userService.getCurrentUser();

        if (currentUser == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        newCustomer.setUser(currentUser);
        return new ResponseEntity<>(repository.save(newCustomer), HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public @ResponseBody
    Customer updateCustomer(@PathVariable Long id, @RequestBody Customer updates) {
        Customer customer = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        if (updates.getCustomerName() != null) customer.setCustomerName(updates.getCustomerName());

        return repository.save(customer);
    }

    @DeleteMapping("/{id")
    public ResponseEntity<String> destroyCustomer(@PathVariable Long id) {
        repository.deleteById(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }

    @DeleteMapping("/remove/self")
    @ResponseBody
    public ResponseEntity<String> deleteSelf() {
        User currentUser = userService.getCurrentUser();

        if (currentUser == null) {
            return null;
        }
        repository.deleteById(currentUser.getId());
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }

}
