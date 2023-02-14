package ru.smallgroup.testtask.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.smallgroup.testtask.models.User;

public interface UserRepository extends CrudRepository<User, Long> {
}
