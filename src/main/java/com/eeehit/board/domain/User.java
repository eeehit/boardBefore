package com.eeehit.board.domain;

import javax.persistence.*;

/**
 * Created by trinity on 17. 5. 18.
 */
@Entity
public class User {
    @Id
    @Column(name = "userKey")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long key;

    @Column(length = 30, nullable = false, unique = true)
    private String id;

    @Column(length = 30, nullable = false)
    private String pw;

    @Column(length = 1, nullable = false)
    private Role role;


    public User() {}

    public User(long key, String id, String pw, Role role) {
        this.setKey(key);
        this.setId(id);
        this.setPw(pw);
        this.setRole(role);
    }
    public User(String id, String pw, Role role) {
        this.setId(id);
        this.setPw(pw);
        this.setRole(role);
    }

    public long getKey() {
        return key;
    }

    public String getId() {
        return id;
    }

    public String getPw() {
        return pw;
    }

    public Role getRole() {
        return role;
    }



    public void setKey(long key) {
        this.key = key;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPw(String userPw) {
        this.pw = userPw;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
