package com.myjetbrains.cronix.roomreservationsystem.model;

import com.myjetbrains.cronix.roomreservationsystem.dto.ApartmentDto;
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
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
public class Apartment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "number")
    private Integer number;
    @Column(name = "area")
    private String area;
    @Column(name = "number_of_beds")
    private Integer numberOfBeds;
    @Column(name = "max_number_of_people")
    private Integer numberOfPeople;
    @Column(name = "description")
    private String description;
    @Column(name = "price_at_season")
    private BigDecimal priceAtSeason;
    @Column(name = "price_after_season")
    private BigDecimal priceAfterSeason;

    @OneToMany(mappedBy = "apartment")
    Set<Reservations> reservations;

    public ApartmentDto toDto() {
        return ApartmentDto.builder()
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
