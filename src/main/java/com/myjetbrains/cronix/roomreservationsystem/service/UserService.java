package com.myjetbrains.cronix.roomreservationsystem.service;

import com.myjetbrains.cronix.roomreservationsystem.dto.NewUserDto;
import com.myjetbrains.cronix.roomreservationsystem.dto.UpdateUserDto;
import com.myjetbrains.cronix.roomreservationsystem.model.User;
import com.myjetbrains.cronix.roomreservationsystem.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public void create(NewUserDto newUserDto) {
        User newUser = User.builder()
                .login(newUserDto.getLogin())
                .password(passwordEncoder.encode(newUserDto.getPassword()))
                .emailAdress(newUserDto.getEmail())
                .build();
        userRepository.save(newUser);
    }

    @Transactional
    public void update(UpdateUserDto updateUserDto){
        User user = userRepository.findById(updateUserDto.getId())
                .orElseThrow(IllegalArgumentException::new);
        user.setName(updateUserDto.getName());
        user.setSurname(updateUserDto.getSurname());
        user.setPhoneNumber(updateUserDto.getPhoneNumber());
        user.setEmailAdress(updateUserDto.getEmailAdress());
    }
}
