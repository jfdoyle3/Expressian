package com.careerdevs.expressian.repositories;

import com.careerdevs.expressian.entities.location.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface LocationRepository extends JpaRepository<Location,Long> {
}
