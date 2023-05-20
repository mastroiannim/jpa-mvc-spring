package edu.itispaleocapa.mastroiannim.services;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import edu.itispaleocapa.mastroiannim.entity.User;
import edu.itispaleocapa.mastroiannim.repository.UserRepository;

@Service
public class UsersService {
    private static final Logger LOG = LoggerFactory.getLogger(LoginService.class);
    private final UserRepository userRepository;

    public UsersService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        LOG.info("getUsers()");
        return userRepository.findAll();
    }

    public List<User> getUsersNoPassword() {
        List<User> users = userRepository.findAll();

        // Remove the password field using stream and function
        Function<User, User> removePassword = user -> {
            User u = new User(user);
            u.setPassword(null);
            return u;
        };

        return users.stream()
                .map(removePassword)
                .collect(Collectors.toList());
    }

}
