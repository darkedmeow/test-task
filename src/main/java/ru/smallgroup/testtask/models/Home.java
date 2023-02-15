package ru.smallgroup.testtask.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "HOMES")
public class Home {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String address;

    private Long ownerId;

    @OneToMany
    @JoinColumn(name = "home_id")
    private List<User> residents = new ArrayList<>();

    public void addResident(User user) {
        residents.add(user);
    }

}
