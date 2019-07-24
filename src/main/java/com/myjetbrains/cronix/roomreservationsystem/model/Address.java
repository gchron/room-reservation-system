package com.myjetbrains.cronix.roomreservationsystem.model;

import com.myjetbrains.cronix.roomreservationsystem.dto.AddressDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    private String street;
    @Column(name = "house_number")
    private String houseNumber;
    @Column(name = "apartment_number")
    private String apartmentNumber;
    @Column(name = "postal_code")
    private String postalCode;
    private String city;

    public AddressDto toDto() {
        return AddressDto.builder()
                .id(id)
                .street(street)
                .houseNumber(houseNumber)
                .apartmentNumber(apartmentNumber)
                .postalCode(postalCode)
                .city(city)
                .build();
    }
}
