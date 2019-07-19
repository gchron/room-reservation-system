package com.myjetbrains.cronix.roomreservationsystem.repository;

import com.myjetbrains.cronix.roomreservationsystem.model.Reservations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservations, Long> {
}
