package ru.smallgroup.testtask.services;

import ru.smallgroup.testtask.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User createUser(User user);
    Optional<User> getUserById(Long id);
    List<User> getAll();
    User updateUser(User user, Long userId);
    void deleteUser(User user);

}
