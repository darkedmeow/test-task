package ru.smallgroup.testtask.services;

import ru.smallgroup.testtask.models.User;
import ru.smallgroup.testtask.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> getAll() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User updateUser(User user, Long userId) {
        var updatedUser = userRepository.findById(userId);
        if (updatedUser.isEmpty()) {
            throw new RuntimeException();
        }
        updatedUser.get().setName(user.getName());
        updatedUser.get().setAge(user.getAge());
        updatedUser.get().setPassword(user.getPassword());
        return userRepository.save(updatedUser.get());
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
