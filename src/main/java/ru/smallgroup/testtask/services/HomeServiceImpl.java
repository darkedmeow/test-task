package ru.smallgroup.testtask.services;

import ru.smallgroup.testtask.models.Home;
import ru.smallgroup.testtask.models.User;
import ru.smallgroup.testtask.repositories.HomeRepository;

import java.util.List;
import java.util.Optional;

public class HomeServiceImpl implements HomeService {

    private final HomeRepository homeRepository;

    public HomeServiceImpl(HomeRepository homeRepository) {
        this.homeRepository = homeRepository;
    }

    @Override
    public Home createHome(Home home) {
        return homeRepository.save(home);
    }

    @Override
    public Optional<Home> getHomeById(Long id) {
        return homeRepository.findById(id);
    }

    @Override
    public List<Home> getAll() {
        return (List<Home>) homeRepository.findAll();
    }

    @Override
    public Home updateHome(Home home, Long homeId) {
        var updatedHome = homeRepository.findById(homeId);
        if (updatedHome.isEmpty()) {
            throw new RuntimeException();
        }
        updatedHome.get().setAddress(home.getAddress());
        return homeRepository.save(updatedHome.get());
    }

    @Override
    public void deleteHome(Long homeId) {
        homeRepository.deleteById(homeId);
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
