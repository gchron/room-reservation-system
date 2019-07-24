package com.myjetbrains.cronix.roomreservationsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReservationsDto {

    private Long id;
    private String dateFrom;
    private String dateTo;
    private Long apartmentId;
    private Long userId;
}
