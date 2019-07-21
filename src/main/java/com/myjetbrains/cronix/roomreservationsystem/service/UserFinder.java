package com.myjetbrains.cronix.roomreservationsystem.service;

import com.myjetbrains.cronix.roomreservationsystem.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserFinder {

    private final UserRepository userRepository;

}
