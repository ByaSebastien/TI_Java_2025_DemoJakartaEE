package be.bstorm.demojakartaee.services.impls;

import be.bstorm.demojakartaee.entities.User;
import be.bstorm.demojakartaee.repositories.UserRepository;
import be.bstorm.demojakartaee.services.UserService;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import org.mindrot.jbcrypt.BCrypt;

import java.io.Serializable;

@SessionScoped
public class UserServiceImpl implements UserService, Serializable {

    @Inject
    private UserRepository userRepository;

    public UserServiceImpl() {}

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void Register(User user) {
        if(userRepository.existsByUsername(user.getUsername())){
            throw new IllegalArgumentException("Username is already in use");
        }
        if(user.getRole() == null){
            user.setRole("user");
        }
        String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashedPassword);
        userRepository.save(user);
    }

    @Override
    public User Login(String username, String password) {
        User user = userRepository.findByUsername(username).orElseThrow();
        if(!BCrypt.checkpw(password, user.getPassword())){
            throw new IllegalArgumentException("Wrong password");
        }
        return user;
    }
}
