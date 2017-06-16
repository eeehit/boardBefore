package com.eeehit.board.domain;

import javax.persistence.*;
import java.util.Set;

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

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(joinColumns = @JoinColumn(name = "userKey"),inverseJoinColumns = @JoinColumn(name = "roleKey"))
    private Set<Role> roles;

    public User() {
    }

    public User(String id) {
        this.id = id;
    }

    public User(String id, String pw) {
        this.id = id;
        this.pw = pw;
    }

    public User(String id, Set<Role> roles) {
        this.id = id;
        this.roles = roles;
    }

    public User(String id, String pw, Set<Role> roles) {
        this.id = id;
        this.pw = pw;
        this.roles = roles;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
