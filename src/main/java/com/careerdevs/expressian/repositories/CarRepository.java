package com.careerdevs.expressian.repositories;

import com.careerdevs.expressian.entities.Car;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findAllByModel(String model, Sort sort);
}
