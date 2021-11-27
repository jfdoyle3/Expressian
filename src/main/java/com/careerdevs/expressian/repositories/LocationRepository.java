package com.careerdevs.expressian.repositories;

import com.careerdevs.expressian.entities.location.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location,Long> {
}
