package ru.smallgroup.testtask.services;

import ru.smallgroup.testtask.models.Home;
import ru.smallgroup.testtask.models.User;

import java.util.List;
import java.util.Optional;

public interface HomeService {

    Home createHome(Home home);
    Optional<Home> getHomeById(Long id);
    List<Home> getAll();
    Home updateHome(Home home, Long homeId);
    void deleteHome(Home home);
    Home addResident(Long homeId, User resident);
}
