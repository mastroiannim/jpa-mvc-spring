package edu.itispaleocapa.mastroiannim.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.itispaleocapa.mastroiannim.entity.Message;

public interface MessageRepository extends JpaRepository<Message, Long>{

	List<Message> findByChat_Id(Long chatId);
    

}
