package com.myjetbrains.cronix.roomreservationsystem.service;

import com.myjetbrains.cronix.roomreservationsystem.dto.ApartmentDto;
import com.myjetbrains.cronix.roomreservationsystem.model.Apartment;
import com.myjetbrains.cronix.roomreservationsystem.repository.ApartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApartmentService {

    private final ApartmentRepository apartmentRepository;

    public void createOrUpdate(ApartmentDto apartmentDto) {
        Apartment newRoom = Apartment.builder()
                .id(apartmentDto.getId())
                .number(apartmentDto.getNumber())
                .area(apartmentDto.getArea())
                .numberOfBeds(apartmentDto.getNumberOfBeds())
                .numberOfPeople(apartmentDto.getNumberOfPeople())
                .description(apartmentDto.getDescription())
                .priceAtSeason(apartmentDto.getPriceAtSeason())
                .priceAfterSeason(apartmentDto.getPriceAfterSeason())
                .build();

        apartmentRepository.save(newRoom);
    }

    public void delete(Long id) {
        apartmentRepository.delete(apartmentRepository.findById(id).orElseThrow(IllegalArgumentException::new));
    }
}
