package ru.smallgroup.testtask.services;

import ru.smallgroup.testtask.models.User;

import java.util.Optional;

public class UserServiceImpl implements UserService {

    @Override
    public User createUser(String name, String password, int age) {
        return null;
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return Optional.empty();
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public boolean deleteUser(User user) {
        return false;
    }
}
