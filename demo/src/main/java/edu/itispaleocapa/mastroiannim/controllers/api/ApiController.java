package edu.itispaleocapa.mastroiannim.controllers.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.itispaleocapa.mastroiannim.services.ChatService;
import edu.itispaleocapa.mastroiannim.services.UsersService;


@RestController
public class ApiController {

    private final UsersService usersService;
    private final ChatService chatService;
    private final ObjectMapper objectMapper;


    public ApiController(UsersService usersService, ChatService chatService, ObjectMapper objectMapper) {
        this.usersService = usersService;
        this.chatService = chatService;
        this.objectMapper = objectMapper;
        this.objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    
    @GetMapping("/api")
    public String index(){
        return "index";
    }

    @GetMapping("/api/user")
    public String getUsers() throws JsonProcessingException{            
        return objectMapper.writeValueAsString(usersService.getUsersNoPassword());
    }

    @GetMapping("/api/user/{id}/chat")
    public String getUserChat(@PathVariable("id") String userId) throws JsonProcessingException{
        // Use the userId as needed
        return objectMapper.writeValueAsString(chatService.getChatsByUserId(Long.parseLong(userId)));

        //return chatService.getChatsByUserId(Long.parseLong(userId));
    }
}
