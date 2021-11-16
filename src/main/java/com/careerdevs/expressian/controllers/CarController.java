package com.careerdevs.expressian.controllers;

import com.careerdevs.expressian.entities.Car;
import com.careerdevs.expressian.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/cars")
public class CarController {

    @Autowired
    private CarRepository repository;

    @GetMapping
    public @ResponseBody
    List<Car> getCars() {
        return repository.findAll();
    }

//    @GetMapping("/Type/{Type}")
//    public ResponseEntity<List<Car>> getCarsByType(@PathVariable String model) {
//        return new ResponseEntity<>(repository.findAllByModel(model, Sort.by("name")), HttpStatus.OK);
//    }

    @GetMapping("/{id}")
    public @ResponseBody Car getOneCar(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }


    @PostMapping
    public ResponseEntity<Car> createCar(@RequestBody Car newCar) {
        return new ResponseEntity<>(repository.save(newCar), HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public @ResponseBody Car updateCar(@PathVariable Long id, @RequestBody Car updates) {
        Car car = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));


        if (updates.getName() != null) car.setName(updates.getName());
        if (updates.getBrand() != null) car.setBrand(updates.getBrand());
        if (updates.getType() != null) car.setType(updates.getType());
        if (updates.getYear() != null) car.setYear(updates.getYear());
        return repository.save(car);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> destroyCar(@PathVariable Long id) {
        repository.deleteById(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }

}
