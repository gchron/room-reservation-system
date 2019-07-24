package com.myjetbrains.cronix.roomreservationsystem.controllers;

import com.myjetbrains.cronix.roomreservationsystem.service.UserFinder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;

@RequiredArgsConstructor
@Controller
class MainViewController {

    private final UserFinder userFinder;

    @RequestMapping({"/",""})
    ModelAndView mainView() {
        ModelAndView modelAndView = new ModelAndView("index.html");
        modelAndView.addObject("todayDate", LocalDate.now());
        return modelAndView;
    }
}

