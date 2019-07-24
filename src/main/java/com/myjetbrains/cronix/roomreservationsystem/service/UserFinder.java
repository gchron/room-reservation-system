package com.myjetbrains.cronix.roomreservationsystem.service;

import com.myjetbrains.cronix.roomreservationsystem.dto.UpdateUserDto;
import com.myjetbrains.cronix.roomreservationsystem.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserFinder {

    private final UserRepository userRepository;

    public UpdateUserDto findById(Long id) {
        return userRepository.findById(id).map(user -> user.toDto())
                .orElseThrow(IllegalArgumentException::new);
    }

    public UpdateUserDto findByLogin(String userName) {
        return userRepository.findByLogin(userName)
                .toDto();
    }
}
