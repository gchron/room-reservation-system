package com.myjetbrains.cronix.roomreservationsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class UpdateAddressDto {

    private Long id;
    private String street;
    private String houseNumber;
    private String apartmentNumber;
    private String postalCode;
    private String city;


}
