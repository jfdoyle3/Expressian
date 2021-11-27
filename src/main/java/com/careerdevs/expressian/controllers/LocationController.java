package com.careerdevs.expressian.controllers;

import com.careerdevs.expressian.entities.location.Location;
import com.careerdevs.expressian.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/locations")
public class LocationController {

    @Autowired
    private LocationRepository respository;

    @GetMapping
    @ResponseBody
    public List<Location> getLocations(){return respository.findAll();}

    @GetMapping("/{id}")
    public Location getOneLocation(@PathVariable Long id){
        return respository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Location> createLocation(@RequestBody Location newLocation){
        return new ResponseEntity<>(respository.save(newLocation), HttpStatus.CREATED);
    }
}
