package ru.smallgroup.testtask.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.smallgroup.testtask.models.Home;
import ru.smallgroup.testtask.services.HomeService;

import java.util.List;

@RestController
@RequestMapping("/users/{uid}/homes")
public class HomeController {

    private final HomeService homeService;

    public HomeController(HomeService homeService) {
        this.homeService = homeService;
    }

    @GetMapping
    public ResponseEntity<?> showAllHomes() {
        final List<Home> homes = homeService.getAll();
        return homes.isEmpty()
                ? new ResponseEntity<>(homes, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Home home, @PathVariable("uid") Long uid) {
        home.setOwnerId(uid);
        final Home createdHome = homeService.createHome(home);
        homeService.addResident(home.getId(), uid);
        return new ResponseEntity<>(createdHome, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> show(@PathVariable("id") Long id) {
        final var home = homeService.getHomeById(id);
        return home.isPresent()
                ? new ResponseEntity<>(home.get(), HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody Home home) {
        final Home updatedHome = homeService.updateHome(home, id);
        return new ResponseEntity<>(updatedHome, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        homeService.deleteHome(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
