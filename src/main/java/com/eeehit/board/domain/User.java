package com.eeehit.board.domain;

import lombok.Getter;

import javax.persistence.*;

/**
 * Created by trinity on 17. 5. 18.
 */
@Entity
public class User {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(length = 255, nullable = false, unique = true)
    private String userId;

    @Column(length = 255, nullable = false)
    private String userPw;

    public User() {
        this.setUserId(null);
        this.setUserPw(null);
    }

    public User(String userId, String userPw) {
        this.setUserId(userId);
        this.setUserPw(userPw);
    }

    private void setUserId(String userId) {
        this.userId = userId;
    }

    private void setUserPw(String userPw) {
        this.userPw = userPw;
    }

    public long getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserPw() {
        return userPw;
    }
}
