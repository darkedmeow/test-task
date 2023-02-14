package ru.smallgroup.testtask.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.smallgroup.testtask.models.Home;

public interface HomeRepository extends CrudRepository<Home, Long> {
}
