package com.myjetbrains.cronix.roomreservationsystem.dto;

import lombok.Data;

@Data
public class UserAddressAssigment {

    private Long userId;
    private Long addressId;
    private String street;
    private String houseNumber;
    private String apartmentNumber;
    private String postalCode;
    private String city;
    private String name;
    private String surname;
    private String phoneNumber;
    private String emailAdress;

}
