package edu.itispaleocapa.mastroiannim.services;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.itispaleocapa.mastroiannim.entity.Message;
import edu.itispaleocapa.mastroiannim.repository.MessageRepository;
import edu.itispaleocapa.mastroiannim.repository.UserRepository;

@Service
public class MessageService {
    private final MessageRepository messageRepository;
    private final UserRepository userRepository;   

    public MessageService(MessageRepository messageRepository, UserRepository userRepository) {
        this.messageRepository = messageRepository;
        this.userRepository = userRepository;
    }

    public List<Message> getMessagesByChatId(Long chatId) {
        return messageRepository.findByChat_Id(chatId);
    }

    public Message saveMessage(String message, Long chatId, String username) {
        Message newMessage = new Message();
        newMessage.setContent(message);
        newMessage.setChat_id(chatId);;
        newMessage.setSender_id(userRepository.findByUsername(username).getId());
        messageRepository.save(newMessage);
        return newMessage;
    }
}
