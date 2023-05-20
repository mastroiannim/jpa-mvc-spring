package edu.itispaleocapa.mastroiannim.services;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.itispaleocapa.mastroiannim.entity.Chat;
import edu.itispaleocapa.mastroiannim.repository.ChatUserRepository;

@Service
public class ChatService {
    private final ChatUserRepository chatUserRepository;

    public ChatService(ChatUserRepository chatUserRepository) {
        this.chatUserRepository = chatUserRepository;
    }

    public List<Chat> getChatsByUserId(Long userId) {
        return chatUserRepository.findChatsByUserId(userId);
    }

    public List<Chat> getChatsByUsername(String username) {
        return chatUserRepository.findChatsByUsername(username);
    }
}
