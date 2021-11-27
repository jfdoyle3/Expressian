package com.careerdevs.expressian.repositories;

import com.careerdevs.expressian.entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location,Long> {
}
