package com.myjetbrains.cronix.roomreservationsystem.service;

import com.myjetbrains.cronix.roomreservationsystem.dto.ChangeUserPasswordDto;
import com.myjetbrains.cronix.roomreservationsystem.dto.NewUserDto;
import com.myjetbrains.cronix.roomreservationsystem.dto.UserAddressAssigment;
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
    public void update(UserAddressAssigment userAddressAssigment) {
        User user = userRepository.findById(userAddressAssigment.getUserId())
                .orElseThrow(IllegalArgumentException::new);
        user.setName(userAddressAssigment.getName());
        user.setSurname(userAddressAssigment.getSurname());
        user.setPhoneNumber(userAddressAssigment.getPhoneNumber());
        user.setEmailAdress(userAddressAssigment.getEmailAdress());
    }

    @Transactional
    public void changePassword(ChangeUserPasswordDto changeUserPasswordDto) {
        User user = userRepository.findById(changeUserPasswordDto.getId())
                .orElseThrow(IllegalArgumentException::new);
        user.setPassword(passwordEncoder.encode(changeUserPasswordDto.getPassword()));
    }
}
