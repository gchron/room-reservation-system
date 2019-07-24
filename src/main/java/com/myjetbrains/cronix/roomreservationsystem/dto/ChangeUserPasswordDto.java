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
public class ChangeUserPasswordDto {

    private Long id;
    private String login;
    private String password;

    public User toEntity() {
        return User.builder()
                .id(id)
                .login(login)
                .password(password)
                .build();
    }
}
