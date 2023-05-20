package edu.itispaleocapa.mastroiannim.services;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.itispaleocapa.mastroiannim.entity.Message;
import edu.itispaleocapa.mastroiannim.repository.MessageRepository;

@Service
public class MessageService {
    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public List<Message> getMessagesByChatId(Long chatId) {
        return messageRepository.findByChat_Id(chatId);
    }
}
