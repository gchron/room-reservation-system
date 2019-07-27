package com.myjetbrains.cronix.roomreservationsystem.controllers;

import com.myjetbrains.cronix.roomreservationsystem.dto.AddressDto;
import com.myjetbrains.cronix.roomreservationsystem.dto.ChangeUserPasswordDto;
import com.myjetbrains.cronix.roomreservationsystem.dto.NewUserDto;
import com.myjetbrains.cronix.roomreservationsystem.dto.UpdateUserDto;
import com.myjetbrains.cronix.roomreservationsystem.dto.UserAddressAssigment;
import com.myjetbrains.cronix.roomreservationsystem.service.AddressFinder;
import com.myjetbrains.cronix.roomreservationsystem.service.AddressService;
import com.myjetbrains.cronix.roomreservationsystem.service.ReservationsFinder;
import com.myjetbrains.cronix.roomreservationsystem.service.UserFinder;
import com.myjetbrains.cronix.roomreservationsystem.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserFinder userFinder;
    private final UserService userService;
    private final AddressFinder addressFinder;
    private final AddressService addressService;
    private final ReservationsFinder reservationsFinder;

    @GetMapping("/register")
    ModelAndView registerUser() {
        ModelAndView modelAndView = new ModelAndView("user/register.html");
        modelAndView.addObject("user", new NewUserDto());
        return modelAndView;
    }

    @PostMapping("/register")
    String createUser(@ModelAttribute NewUserDto newUserDto) {
        userService.create(newUserDto);
        return "redirect:/login";
    }
    @PreAuthorize("hasRole('USER') OR hasRole('ADMINISTRATOR')")
    @GetMapping("/profile")
    ModelAndView showUserDetails(Principal principal) {
        ModelAndView modelAndView = new ModelAndView("user/profile.html");
        Long userId = userFinder.findByLogin(principal.getName()).getId();
        UpdateUserDto updateUserDto = userFinder.findById(userId);
        modelAndView.addObject("user", updateUserDto);
        modelAndView.addObject("address", addressFinder.findUserAddress(updateUserDto));
        return modelAndView;
    }
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/edit")
    ModelAndView updateUser(@RequestParam(value = "id") Long userId, Principal principal) {
        ModelAndView modelAndView = new ModelAndView("user/edit.html");
        UpdateUserDto updateUserDto = userFinder.findById(userId);
        AddressDto userAddress = userAddress = addressFinder.findUserAddress(updateUserDto);
        modelAndView.addObject("addressId", userAddress.getId());
        modelAndView.addObject("userId", updateUserDto.getId());
        modelAndView.addObject("user", updateUserDto);
        modelAndView.addObject("address", userAddress);
        modelAndView.addObject("assigment", new UserAddressAssigment());
        return modelAndView;
    }

    @PreAuthorize("hasRole('USER')")
    @PostMapping("/edit")
    String updateUserData(@ModelAttribute UserAddressAssigment userAddressAssigment) {
        userService.update(userAddressAssigment);
        if (userAddressAssigment.getAddressId() == null) {
            addressService.create(userAddressAssigment);
        } else {
            addressService.update(userAddressAssigment);
        }
        return "redirect:/user/profile";
    }
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/changePassword")
    ModelAndView changePassword(Principal principal) {
        ModelAndView modelAndView = new ModelAndView("user/changePassword");
        Long userId = userFinder.findByLogin(principal.getName()).getId();
        modelAndView.addObject("user", userFinder.findById(userId));
        return modelAndView;
    }
    @PreAuthorize("hasRole('USER')")
    @PostMapping("/changePassword")
    String changePassword(@ModelAttribute ChangeUserPasswordDto changeUserPasswordDto) {
        userService.changePassword(changeUserPasswordDto);
        return "redirect:/user/profile";
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/reservations")
    ModelAndView showAll(Principal principal) {
        ModelAndView modelAndView = new ModelAndView("user/reservations.html");
        Long userId = userFinder.findByLogin(principal.getName()).getId();
        modelAndView.addObject("user", userFinder.findById(userId).getLogin());
        modelAndView.addObject("reservations", reservationsFinder.findByUserId(userId));
        return modelAndView;
    }
}
