package com.careerdevs.expressian.repositories;

import com.careerdevs.expressian.entities.location.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LocationRepository extends JpaRepository<Location,Long> {

    List<Location> findAllByRented();
}
