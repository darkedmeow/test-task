package ru.smallgroup.testtask.services;

import ru.smallgroup.testtask.models.Home;
import ru.smallgroup.testtask.models.User;

import java.util.Optional;

public interface HomeService {

    Home createHome(Long masterId, String address);
    Optional<Home> getHomeById(Long id);
    Home updateHome(Home home);
    void deleteHome(Home home);
    Home addResident(Long homeId, User resident);
}
