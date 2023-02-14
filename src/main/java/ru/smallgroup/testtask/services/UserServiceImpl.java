package ru.smallgroup.testtask.services;

import ru.smallgroup.testtask.models.User;
import ru.smallgroup.testtask.repositories.UserRepository;

import java.util.Optional;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(String name, String password, int age) {
        User user = new User();
        user.setName(name);
        user.setAge(age);
        user.setPassword(password);

        return userRepository.save(user);
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(User user) {
        userRepository.delete(user);
    }
}
