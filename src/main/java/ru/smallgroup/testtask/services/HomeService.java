package ru.smallgroup.testtask.services;

import ru.smallgroup.testtask.models.Home;
import ru.smallgroup.testtask.models.User;

import java.util.Optional;

public interface HomeService {

    Home createHome(User owner);
    Optional<Home> getHomeById(Long id);
    Home updateHome(Home home);
    boolean deleteHome(Home home);

    Home addResident(User resident);

}
