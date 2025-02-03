package be.bstorm.demojakartaee.services;

import be.bstorm.demojakartaee.entities.User;

public interface UserService {

    void Register(User user);
    User Login(String username, String password);
}
