package com.myjetbrains.cronix.roomreservationsystem.service;

import com.myjetbrains.cronix.roomreservationsystem.dto.UserAddressAssigment;
import com.myjetbrains.cronix.roomreservationsystem.model.Address;
import com.myjetbrains.cronix.roomreservationsystem.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;
    private final UserFinder userFinder;

    @Transactional
    public void update(UserAddressAssigment userAddressAssigment) {
        Address address = addressRepository.findById(userAddressAssigment.getAddressId())
                .orElseThrow(IllegalArgumentException::new);
        address.setCity(userAddressAssigment.getCity());
        address.setApartmentNumber(userAddressAssigment.getApartmentNumber());
        address.setHouseNumber(userAddressAssigment.getHouseNumber());
        address.setPostalCode(userAddressAssigment.getPostalCode());
        address.setStreet(userAddressAssigment.getStreet());
        address.setUser(userFinder.findById(userAddressAssigment.getUserId()).toEntity());
    }

    public void create(UserAddressAssigment userAddressAssigment) {
        Address address = Address.builder()
                .user(userFinder.findById(userAddressAssigment.getUserId()).toEntity())
                .street(userAddressAssigment.getStreet())
                .houseNumber(userAddressAssigment.getHouseNumber())
                .apartmentNumber(userAddressAssigment.getApartmentNumber())
                .postalCode(userAddressAssigment.getPostalCode())
                .city(userAddressAssigment.getCity())
                .build();
        addressRepository.save(address);
    }
}
