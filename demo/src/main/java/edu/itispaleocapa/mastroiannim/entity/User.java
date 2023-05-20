package edu.itispaleocapa.mastroiannim.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;

    public User() {
        //default constructor
    }
    
    public User(User user) {
        //copy constructor
        this.id = user.getId(); 
        this.username = user.getUsername();
        this.password = user.getPassword();
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public Long getId() {
        return id;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String toString(){
        return id + "#" + username;
    }
    // Constructors, getters, setters, and other methods
    
}
