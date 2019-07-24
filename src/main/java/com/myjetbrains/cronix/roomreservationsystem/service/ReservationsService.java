package com.myjetbrains.cronix.roomreservationsystem.service;

import com.myjetbrains.cronix.roomreservationsystem.dto.ReservationsDto;
import com.myjetbrains.cronix.roomreservationsystem.model.Reservations;
import com.myjetbrains.cronix.roomreservationsystem.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class ReservationsService {

    private final ReservationRepository reservationRepository;
    private final UserFinder userFinder;
    private final ApartmentFinder apartmentFinder;

    public void create(ReservationsDto reservationsDto) {
        Reservations reservations = Reservations.builder()
                .dateFrom(LocalDate.parse(reservationsDto.getDateFrom()))
                .dateTo(LocalDate.parse(reservationsDto.getDateTo()))
                .user(userFinder.findById(reservationsDto.getUserId()).toEntity())
                .apartment(apartmentFinder.findById(reservationsDto.getApartmentId()).toEntity())
                .build();
        reservationRepository.save(reservations);
    }
}
