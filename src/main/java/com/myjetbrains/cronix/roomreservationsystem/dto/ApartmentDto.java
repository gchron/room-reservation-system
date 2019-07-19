package com.myjetbrains.cronix.roomreservationsystem.dto;

import com.myjetbrains.cronix.roomreservationsystem.model.Apartment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class ApartmentDto {

    private Long id;
    private Integer number;
    private String area;
    private Integer numberOfBeds;
    private Integer numberOfPeople;
    private String description;
    private BigDecimal priceAtSeason;
    private BigDecimal priceAfterSeason;


    public Apartment toEntity() {
        return Apartment.builder()
                .id(id)
                .number(number)
                .area(area)
                .numberOfBeds(numberOfBeds)
                .numberOfPeople(numberOfPeople)
                .description(description)
                .priceAtSeason(priceAtSeason)
                .priceAfterSeason(priceAfterSeason)
                .build();
    }
}
