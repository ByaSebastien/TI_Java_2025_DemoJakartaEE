package be.bstorm.demojakartaee.repositories;

import be.bstorm.demojakartaee.entities.User;

import java.util.Optional;

public interface UserRepository {

    void save(User user);
    boolean existsByUsername(String username);
    Optional<User> findByUsername(String username);
}
