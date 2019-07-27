package com.myjetbrains.cronix.roomreservationsystem.controllers;

import com.myjetbrains.cronix.roomreservationsystem.dto.ReservationsDto;
import com.myjetbrains.cronix.roomreservationsystem.service.ApartmentFinder;
import com.myjetbrains.cronix.roomreservationsystem.service.ReservationsFinder;
import com.myjetbrains.cronix.roomreservationsystem.service.ReservationsService;
import com.myjetbrains.cronix.roomreservationsystem.service.UserFinder;
import com.myjetbrains.cronix.roomreservationsystem.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
@RequestMapping("/reservations")
public class ReservationsController {
    private final ReservationsFinder reservationsFinder;
    private final ReservationsService reservationsService;
    private final UserFinder userFinder;
    private final UserService userService;
    private final ApartmentFinder apartmentFinder;

    @GetMapping("/book")
    ModelAndView createReservation(@RequestParam Long id, Principal principal) {
        ModelAndView modelAndView = new ModelAndView("reservations/create.html");
        Long userId = userFinder.findByLogin(principal.getName()).getId();
        modelAndView.addObject("reservation", new ReservationsDto());
        modelAndView.addObject("apartment", apartmentFinder.findById(id));
        modelAndView.addObject("user", userFinder.findById(userId));
        return modelAndView;
    }

    @PostMapping("/book")
    String createReservation(ReservationsDto reservationsDto) {
        reservationsService.create(reservationsDto);
        return "redirect:/";
    }

    @GetMapping("/delete")
    String delete(@RequestParam(name = "id") Long id) {
        reservationsService.delete(id);
        return "redirect:/";
    }
}
