package com.myjetbrains.cronix.roomreservationsystem.service;

import com.myjetbrains.cronix.roomreservationsystem.dto.AddressDto;
import com.myjetbrains.cronix.roomreservationsystem.dto.UpdateUserDto;
import com.myjetbrains.cronix.roomreservationsystem.model.Address;
import com.myjetbrains.cronix.roomreservationsystem.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressFinder {

    private final AddressRepository addressRepository;

    public AddressDto findUserAddress(UpdateUserDto userDto) {
        Address addressesByUser = addressRepository.findAddressesByUser(userDto.toEntity());
        if (addressesByUser == null) {
            return new AddressDto();
        } else {
            return addressesByUser.toDto();
        }
    }
}
