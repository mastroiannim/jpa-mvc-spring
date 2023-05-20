package edu.itispaleocapa.mastroiannim.entity;

import java.io.Serializable;
import java.util.Objects;

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

    /*
     * When using a composite ID class in Hibernate, it is necessary to override the equals() and 
     * hashCode() methods in the composite ID class. This is because Hibernate relies on these 
     * methods to correctly compare and identify objects with composite IDs.
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChatUserId that = (ChatUserId) o;
        return Objects.equals(chat_id, that.chat_id) &&
                Objects.equals(user_id, that.user_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(chat_id, user_id);
    }

    // standard constructors, getters, and setters  
    

}