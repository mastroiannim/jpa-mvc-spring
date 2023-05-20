package edu.itispaleocapa.mastroiannim.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import edu.itispaleocapa.mastroiannim.entity.User;
import edu.itispaleocapa.mastroiannim.repository.UserRepository;

@Service
public class LoginService {
    private static final Logger LOG = LoggerFactory.getLogger(LoginService.class);
    private final UserRepository userRepository;

    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean authenticate(String username, String password) {    
        User user = userRepository.findByUsername(username);
        LOG.info(userRepository.findAll().toString());
        return user != null && user.getPassword().equals(password);
    }
}
