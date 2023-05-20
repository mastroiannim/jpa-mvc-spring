package edu.itispaleocapa.mastroiannim.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Message {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "chat_id", referencedColumnName = "id", insertable=false, updatable=false)
    private Chat chat;

    @ManyToOne
    @JoinColumn(name = "sender_id", referencedColumnName = "id", insertable=false, updatable=false)
    @JsonIgnoreProperties("password") // Exclude user details during serialization
    private User sender;

    private String content;
    private String sent_at;

    public Message() {
        //default constructor
    }

    public Message(Message message) {
        //copy constructor
        this.id = message.getId(); 
        this.content = message.getContent();
        this.sent_at = message.getSent_at();
        this.chat = message.getChat();
        this.sender = message.getSender();
    }

	public Long getId() {
		return id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSent_at() {
		return sent_at;
	}

	public void setSent_at(String sent_at) {
		this.sent_at = sent_at;
	}

	public Chat getChat() {
		return chat;
	}

	public void setChat(Chat chat) {
		this.chat = chat;
	}

	public User getSender() {
		return sender;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}

}
