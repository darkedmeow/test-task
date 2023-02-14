package ru.smallgroup.testtask.services;

import ru.smallgroup.testtask.models.User;

import java.util.Optional;

public interface UserService {

    User createUser(String name, String password, int age);
    Optional<User> getUserById(Long id);
    User updateUser(User user);
    boolean deleteUser(User user);

}
