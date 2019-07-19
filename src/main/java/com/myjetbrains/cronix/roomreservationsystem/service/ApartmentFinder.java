package com.myjetbrains.cronix.roomreservationsystem.service;

import com.myjetbrains.cronix.roomreservationsystem.dto.ApartmentDto;
import com.myjetbrains.cronix.roomreservationsystem.repository.ApartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ApartmentFinder {

    private final ApartmentRepository apartmentRepository;

    public Set<ApartmentDto> findAll() {
        return apartmentRepository.findAll()
                .stream()
                .map(room -> room.toDto())
                .collect(Collectors.toSet());
    }

    public ApartmentDto findById(Long apartmentId) {
        return apartmentRepository.findById(apartmentId)
                .map(room -> room.toDto())
                .orElseThrow(IllegalArgumentException::new);
    }

    public ApartmentDto findByApartmentNumber(Integer id){
        return  apartmentRepository.findByNumber(id)
                .map(room -> room.toDto())
                .orElseThrow(IllegalArgumentException::new);
    }
}
