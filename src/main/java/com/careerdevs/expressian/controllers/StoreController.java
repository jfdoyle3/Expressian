package com.careerdevs.expressian.controllers;


import com.careerdevs.expressian.entities.Car;

import com.careerdevs.expressian.entities.Store;
import com.careerdevs.expressian.repositories.CarRepository;
import com.careerdevs.expressian.repositories.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/stores")
public class StoreController {

    @Autowired
    private StoreRepository repository;

    @Autowired
    private CarRepository carRepository;

    @GetMapping
    @ResponseBody
    public List<Store> getStores() {
        return repository.findAll();
    }


    @PostMapping
    public ResponseEntity<Store> createCar(@RequestBody Store newStore) {
        return new ResponseEntity<>(repository.save(newStore), HttpStatus.CREATED);
    }

    @PostMapping("/{carId}")
    public @ResponseBody Store newStore(@PathVariable Long carId, @RequestBody Store newStore) {
        Car car = carRepository.findById(carId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Car Not Found"));
        newStore.setCar(car);
        return repository.save(newStore);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> destroyCar(@PathVariable Long id) {
        repository.deleteById(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }

}
