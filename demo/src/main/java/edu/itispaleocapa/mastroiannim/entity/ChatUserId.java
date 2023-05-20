package edu.itispaleocapa.mastroiannim.entity;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

@Embeddable
public class ChatUserId implements Serializable {
    private Long chat_id;
    private Long user_id;

    public Long getChat_id() {
        return chat_id;
    }
    public void setChat_id(Long chat_id) {
        this.chat_id = chat_id;
    }
    public Long getUser_id() {
        return user_id;
    }
    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    // standard constructors, getters, and setters  
    

}