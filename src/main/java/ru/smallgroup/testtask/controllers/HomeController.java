package ru.smallgroup.testtask.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.smallgroup.testtask.services.HomeService;

@RestController
@RequestMapping("/users/{userId}/homes")
public class HomeController {

    private final HomeService homeService;

    public HomeController(HomeService homeService) {
        this.homeService = homeService;
    }

}
