package edu.itispaleocapa.mastroiannim.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.itispaleocapa.mastroiannim.repository.UserRepository;

@Service
public class UsersService {
    private static final Logger LOG = LoggerFactory.getLogger(LoginService.class);
    private final UserRepository userRepository;

    @Autowired
    public UsersService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String getUsers() {
        return userRepository.findAll().toString();
    }
}
