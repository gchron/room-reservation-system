package com.myjetbrains.cronix.roomreservationsystem.model;

import com.myjetbrains.cronix.roomreservationsystem.dto.ReservationsDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Reservations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dateFrom;
    private LocalDate dateTo;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Apartment apartment;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public ReservationsDto toDto(){
        return ReservationsDto.builder()
                .id(id)
                .dateFrom(String.valueOf(dateFrom))
                .dateTo(String.valueOf(dateTo))
                .apartmentId(apartment.getId())
                .userId(user.getId())
                .build();
    }

}
