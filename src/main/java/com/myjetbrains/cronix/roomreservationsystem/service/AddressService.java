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
    public void createOrUpdate(UserAddressAssigment userAddressAssigment) {
        Address address = addressRepository.findById(userAddressAssigment.getAddressId())
                .orElse(new Address());
        address.setCity(userAddressAssigment.getCity());
        address.setApartmentNumber(userAddressAssigment.getApartmentNumber());
        address.setHouseNumber(userAddressAssigment.getHouseNumber());
        address.setPostalCode(userAddressAssigment.getPostalCode());
        address.setStreet(userAddressAssigment.getStreet());
        address.setUser(userFinder.findById(userAddressAssigment.getUserId()).toEntity());
    }
}
