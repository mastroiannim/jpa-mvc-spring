package edu.itispaleocapa.mastroiannim.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ChatUser {

    @EmbeddedId
    private ChatUserId id;

    @ManyToOne
    @JoinColumn(name = "chat_id", referencedColumnName = "id", insertable=false, updatable=false)
    private Chat chat;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable=false, updatable=false)
    private User user;

    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String toString(){
        return chat + "#" + user;
    }

       

}
