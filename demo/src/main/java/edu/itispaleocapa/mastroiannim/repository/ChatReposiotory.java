package edu.itispaleocapa.mastroiannim.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import edu.itispaleocapa.mastroiannim.entity.Chat;

public interface ChatReposiotory extends JpaRepository<Chat, Long> {
    Chat findByName(String name);
}
