package com.myjetbrains.cronix.roomreservationsystem.dto;

import com.myjetbrains.cronix.roomreservationsystem.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UpdateUserDto {

    private Long id;
    private String name;
    private String surname;
    private String phoneNumber;
    private String emailAdress;


    public User toEntity() {
        return User.builder()
                .id(id)
                .surname(surname)
                .phoneNumber(phoneNumber)
                .emailAdress(emailAdress)
                .build();
    }
}
