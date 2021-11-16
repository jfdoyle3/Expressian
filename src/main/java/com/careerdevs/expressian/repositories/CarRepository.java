package com.careerdevs.expressian.repositories;

import com.careerdevs.expressian.entities.Car;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
  //  List<Car> findAllByModel(String model, Sort sort);
}
