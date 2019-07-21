package com.myjetbrains.cronix.roomreservationsystem.dto;

import com.myjetbrains.cronix.roomreservationsystem.model.User;
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
public class NewUserDto {

    private Long id;
    private String login;
    private String email;

    public User toEntity() {
        return User.builder()
                .id(id)
                .login(login)
                .emailAdress(email)
                .build();
    }

}
