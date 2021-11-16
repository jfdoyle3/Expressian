package com.careerdevs.expressian.repositories;


import com.careerdevs.expressian.entities.Car;
import com.careerdevs.expressian.entities.Customer;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Car> findAllByName(String name, Sort sort);
}
