package com.myjetbrains.cronix.roomreservationsystem.controllers;

import com.myjetbrains.cronix.roomreservationsystem.dto.ApartmentDto;
import com.myjetbrains.cronix.roomreservationsystem.service.ApartmentFinder;
import com.myjetbrains.cronix.roomreservationsystem.service.ApartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/apartment")
@RequiredArgsConstructor
public class ApartmentController {

    private final ApartmentFinder apartmentFinder;
    private final ApartmentService apartmentService;

    @GetMapping("/get/{apartmentNumber}")
    ModelAndView getApartment(@PathVariable Integer apartmentNumber) {
        ModelAndView modelAndView = new ModelAndView("apartment/details.html");
        modelAndView.addObject("apartmentNumber", apartmentNumber);
        modelAndView.addObject("apartment", apartmentFinder.findByApartmentNumber(apartmentNumber));
        return modelAndView;
    }
    @GetMapping("/create")
    ModelAndView createRoom() {
        ModelAndView modelAndView = new ModelAndView("apartment/create.html");
        modelAndView.addObject("apartment", new ApartmentDto());
        return modelAndView;
    }

    @PostMapping("/create")
    String createCar(@ModelAttribute ApartmentDto apartmentDto) {
        apartmentService.createOrUpdate(apartmentDto);
        return "redirect:/apartment/create";
    }

    @RequestMapping({"", "/"})
    ModelAndView findAllRooms() {
        ModelAndView modelAndView = new ModelAndView("apartment/index.html");
        modelAndView.addObject("apartments", apartmentFinder.findAll());
        return modelAndView;
    }
    @GetMapping("/details/{apartmentId}")
    public ModelAndView showCarDetails(@PathVariable Long apartmentId) {
        ModelAndView modelAndView = new ModelAndView("apartment/details.html");
        modelAndView.addObject("apartmentNumber", apartmentFinder.findById(apartmentId).getNumber());
        modelAndView.addObject("apartment", apartmentFinder.findById(apartmentId));
        return modelAndView;
    }
    @GetMapping("/delete")
    String deleteCar(@RequestParam Long id){
        apartmentService.delete(id);
        return "redirect:/apartment/";
    }

    @GetMapping("/edit")
    ModelAndView updateCar(@RequestParam Long id) {
        ModelAndView modelAndView = new ModelAndView("apartment/edit.html");
        modelAndView.addObject("apartment", apartmentFinder.findById(id));
        return modelAndView;
    }

    @PostMapping("/edit")
    String updateCar(@ModelAttribute ApartmentDto apartmentDto) {
        apartmentService.createOrUpdate(apartmentDto);
        return "redirect:/apartment/";
    }
}





















