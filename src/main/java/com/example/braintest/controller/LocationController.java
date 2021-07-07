package com.example.braintest.controller;

import com.example.braintest.model.Location;
import com.example.braintest.service.LocationService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/location")
public class LocationController {

    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping("")
    public ModelAndView view(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("location");
        modelAndView.addObject("location", new Location());
        return modelAndView;
    }

    @PostMapping("/add")
    public HttpEntity<Location> add(@ModelAttribute Location location) {
        Location location1 = locationService.save(location);
        return new ResponseEntity<>(location1, HttpStatus.OK);
    }
}
