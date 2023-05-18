package edu.itispaleocapa.mastroiannim.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.itispaleocapa.mastroiannim.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
