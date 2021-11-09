package com.careerdevs.expressian.repositories;


import com.careerdevs.expressian.entities.Car;
import com.careerdevs.expressian.entities.Customer;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Car> findAllByName(String name, Sort sort);
}
