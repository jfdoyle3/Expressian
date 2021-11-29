package com.careerdevs.expressian.controllers;

import com.careerdevs.expressian.entities.vehicle.Vehicle;
import com.careerdevs.expressian.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

    @Autowired
    private VehicleRepository repository;

    @GetMapping
    @ResponseBody
    public List<Vehicle> getVehicles() {
        return repository.findAll();
    }


    @GetMapping("/{id}")
    @ResponseBody
    public Vehicle getOneVehicle(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/{make}")
    @ResponseBody
    public List<Vehicle> getMakes(@PathVariable String make){ return repository.findAllByMake(make);}


    @PostMapping
    public ResponseEntity<Vehicle> createCar(@RequestBody Vehicle newVehicle) {
        return new ResponseEntity<>(repository.save(newVehicle), HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    @ResponseBody
    public Vehicle updateCar(@PathVariable Long id, @RequestBody Vehicle updates) {
        Vehicle vehicle = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));


        if (updates.getModel() != null) vehicle.setModel(updates.getModel());
        if (updates.getMake() != null) vehicle.setMake(updates.getMake());
        if (updates.getType() != null) vehicle.setType(updates.getType());
        if (updates.getYear() != null) vehicle.setYear(updates.getYear());
        return repository.save(vehicle);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> destroyCar(@PathVariable Long id) {
        repository.deleteById(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }

}
