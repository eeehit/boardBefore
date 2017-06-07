package com.eeehit.board.domain;

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

    @Column(length = 30, nullable = false, unique = true)
    private String userId;

    @Column(length = 30, nullable = false)
    private String userPw;

    @Column(length = 1, nullable = false)
    private Role role;


    public User() {}

    public User(String userId, String userPw, Role role) {
        this.setUserId(userId);
        this.setUserPw(userPw);
        this.setRole(role);
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

    public Role getRole() {
        return role;
    }


    private void setUserId(String userId) {
        this.userId = userId;
    }

    private void setUserPw(String userPw) {
        this.userPw = userPw;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
