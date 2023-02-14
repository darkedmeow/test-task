package ru.smallgroup.testtask.services;

import ru.smallgroup.testtask.models.Home;
import ru.smallgroup.testtask.models.User;

import java.util.Optional;

public class HomeServiceImpl implements HomeService {
    @Override
    public Home createHome(User owner) {
        return null;
    }

    @Override
    public Optional<Home> getHomeById(Long id) {
        return Optional.empty();
    }

    @Override
    public Home updateHome(Home home) {
        return null;
    }

    @Override
    public boolean deleteHome(Home home) {
        return false;
    }

    @Override
    public Home addResident(User resident) {
        return null;
    }
}
