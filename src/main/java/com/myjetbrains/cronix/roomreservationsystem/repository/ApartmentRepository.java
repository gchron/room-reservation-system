package com.myjetbrains.cronix.roomreservationsystem.repository;

import com.myjetbrains.cronix.roomreservationsystem.model.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApartmentRepository extends JpaRepository<Apartment, Long> {

    Optional<Apartment> findByNumber(Integer number);
}
