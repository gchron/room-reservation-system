package com.myjetbrains.cronix.roomreservationsystem.service;

import com.myjetbrains.cronix.roomreservationsystem.dto.ReservationsDto;
import com.myjetbrains.cronix.roomreservationsystem.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReservationsFinder {

    private final ReservationRepository reservationRepository;

    public Set<ReservationsDto> findAll() {
        return reservationRepository.findAll().stream()
                .map(reservations -> reservations.toDto())
                .collect(Collectors.toSet());
    }

    public ReservationsDto findById(Long id) {
        return reservationRepository.findById(id)
                .map(reservations -> reservations.toDto())
                .orElseThrow(IllegalArgumentException::new);
    }

    public Set<ReservationsDto> findByUserId(Long userId) {
        return reservationRepository.findAll().stream()
                .map(reservations -> reservations.toDto())
                .filter(reservations -> reservations.getUserId().equals(userId))
                .collect(Collectors.toSet());
    }
}
