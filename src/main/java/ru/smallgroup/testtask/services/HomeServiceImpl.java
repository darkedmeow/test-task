package ru.smallgroup.testtask.services;

import ru.smallgroup.testtask.models.Home;
import ru.smallgroup.testtask.models.User;
import ru.smallgroup.testtask.repositories.HomeRepository;

import java.util.Optional;

public class HomeServiceImpl implements HomeService {

    private final HomeRepository homeRepository;

    public HomeServiceImpl(HomeRepository homeRepository) {
        this.homeRepository = homeRepository;
    }

    @Override
    public Home createHome(Long masterId, String address) {
        Home home = new Home();
        home.setAddress(address);
        home.setMasterId(masterId);

        return homeRepository.save(home);
    }

    @Override
    public Optional<Home> getHomeById(Long id) {
        return homeRepository.findById(id);
    }

    @Override
    public Home updateHome(Home home) {
        return homeRepository.save(home);
    }

    @Override
    public void deleteHome(Home home) {
        homeRepository.delete(home);
    }

    @Override
    public Home addResident(Long homeId, User resident) {
        var home = homeRepository.findById(homeId);

        if (home.isEmpty()) {
            throw new RuntimeException();
        }
        Home hm = home.get();
        hm.addResident(resident);
        return homeRepository.save(hm);
    }
}
