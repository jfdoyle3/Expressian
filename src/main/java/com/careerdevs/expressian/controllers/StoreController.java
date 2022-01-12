package com.careerdevs.expressian.controllers;


import com.careerdevs.expressian.entities.store.Store;
import com.careerdevs.expressian.repositories.VehicleRepository;
import com.careerdevs.expressian.repositories.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/stores")
public class StoreController {

    @Autowired
    private StoreRepository repository;

    @Autowired
    private VehicleRepository vehicleRepository;

    @GetMapping("/locations")
    @ResponseBody
    public List<Store> getStores() {
        return repository.findAll();
    }


    @PostMapping
    public ResponseEntity<Store> createStore(@RequestBody Store newStore) {
        return new ResponseEntity<>(repository.save(newStore), HttpStatus.CREATED);
    }

//    @PostMapping("/{carId}")
//    public @ResponseBody Store newStore(@PathVariable Long carId, @RequestBody Store newStore) {
//        Car car = carRepository.findById(carId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Car Not Found"));
//        newStore.setCar(car);
//        return repository.save(newStore);
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> destroyCar(@PathVariable Long id) {
        repository.deleteById(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }

}
