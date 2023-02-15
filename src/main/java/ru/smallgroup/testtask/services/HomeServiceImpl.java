package ru.smallgroup.testtask.services;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ru.smallgroup.testtask.models.Home;
import ru.smallgroup.testtask.models.User;
import ru.smallgroup.testtask.repositories.HomeRepository;
import ru.smallgroup.testtask.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class HomeServiceImpl implements HomeService {

    private final HomeRepository homeRepository;
    private final UserRepository userRepository;

    public HomeServiceImpl(HomeRepository homeRepository, UserRepository userRepository) {
        this.homeRepository = homeRepository;
        this.userRepository = userRepository;
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
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        updatedHome.get().setAddress(home.getAddress());
        return homeRepository.save(updatedHome.get());
    }

    @Override
    public void deleteHome(Long homeId) {
        homeRepository.deleteById(homeId);
    }

    @Override
    public Home addResident(Long homeId, Long residentId) {
        var home = homeRepository.findById(homeId);
        var resident = userRepository.findById(residentId);

        if (home.isEmpty() || resident.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        Home hm = home.get();
        hm.addResident(resident.get());
        return homeRepository.save(hm);
    }
}
