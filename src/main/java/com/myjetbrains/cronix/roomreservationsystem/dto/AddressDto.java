package com.myjetbrains.cronix.roomreservationsystem.dto;

import com.myjetbrains.cronix.roomreservationsystem.model.Address;
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
public class AddressDto {

    private Long id;
    private String street;
    private String houseNumber;
    private String apartmentNumber;
    private String postalCode;
    private String city;

    public Address toEntity() {
        return Address.builder().id(id)
                .street(street)
                .houseNumber(houseNumber)
                .apartmentNumber(apartmentNumber)
                .postalCode(postalCode)
                .city(city)
                .build();
    }

}
