package com.careerdevs.expressian.controllers;


import com.careerdevs.expressian.entities.location.Location;
import com.careerdevs.expressian.entities.rental_agreement.RentalAgreement;
import com.careerdevs.expressian.repositories.RentalAgreementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/rental")
public class RentalAgreementController {

    @Autowired
    RentalAgreementRepository repository;


    @GetMapping
    @ResponseBody
    public List<RentalAgreement> getRentalAgreements(){return repository.findAll();}

    @PostMapping
    public ResponseEntity<RentalAgreement> createLocation(@RequestBody RentalAgreement newRentalAgreement){
        return new ResponseEntity<>(repository.save(newRentalAgreement), HttpStatus.CREATED);
    }

}
