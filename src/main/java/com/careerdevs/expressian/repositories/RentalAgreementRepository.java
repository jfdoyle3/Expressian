package com.careerdevs.expressian.repositories;

import com.careerdevs.expressian.entities.rental_agreement.RentalAgreement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalAgreementRepository extends JpaRepository<RentalAgreement, Long> {
}
