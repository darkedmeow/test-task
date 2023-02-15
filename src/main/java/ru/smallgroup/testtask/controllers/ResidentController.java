package ru.smallgroup.testtask.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.smallgroup.testtask.models.User;
import ru.smallgroup.testtask.services.HomeService;

@RestController
@RequestMapping("/users/{uid}/homes/{hid}/residents")
public class ResidentController {

    private final HomeService homeService;

    public ResidentController(HomeService homeService) {
        this.homeService = homeService;
    }

    @GetMapping
    public ResponseEntity<?> showAll(@PathVariable("hid") Long homeId) {
        return ResponseEntity.badRequest().build();
    }

    @PostMapping
    public ResponseEntity<?> addResident(@PathVariable("hid") Long homeId, @RequestBody User user) {
        homeService.addResident(homeId, user);
        return ResponseEntity.ok().build();
    }
}
