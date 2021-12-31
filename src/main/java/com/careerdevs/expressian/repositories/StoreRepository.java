package com.careerdevs.expressian.repositories;

import com.careerdevs.expressian.entities.store.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {
}
