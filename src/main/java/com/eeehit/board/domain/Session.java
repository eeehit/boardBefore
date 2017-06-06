package com.eeehit.board.domain;

/**
 * Created by trinity on 17. 6. 6.
 */
public class Session{

    private User user;


    public Session(User user) {
        this.user = user;
    }


    public User getUser() {
        return user;
    }

    public Long getId() {
        return user.getId();
    }

    public Role getRole() {
        return user.getRole();
    }
}
