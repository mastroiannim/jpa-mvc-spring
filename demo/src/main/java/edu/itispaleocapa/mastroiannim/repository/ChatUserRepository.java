package edu.itispaleocapa.mastroiannim.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.itispaleocapa.mastroiannim.entity.Chat;
import edu.itispaleocapa.mastroiannim.entity.ChatUser;
import edu.itispaleocapa.mastroiannim.entity.ChatUserId;

@Repository
public interface ChatUserRepository extends JpaRepository<ChatUser, ChatUserId> {
    @Query("SELECT cu.chat FROM ChatUser cu WHERE cu.user.id = :userId")
    List<Chat> findChatsByUserId(@Param("userId") Long userId);

    @Query("SELECT cu.chat FROM ChatUser cu WHERE cu.user.username = :username")
    List<Chat> findChatsByUsername(@Param("username") String username);
}



