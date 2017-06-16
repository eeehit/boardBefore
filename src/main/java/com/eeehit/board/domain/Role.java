package com.eeehit.board.domain;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by trinity on 17. 6. 6.
 */
@Entity
public class Role {
    @Id
    @Column(name = "roleKey")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String name;

    @ManyToMany(mappedBy = "roles",fetch = FetchType.LAZY)
    private Set<User> users;

    public Role() {
    }

    public Role(String name) {
        this.name = name;
    }

    public Role(String name, Set<User> users) {
        this.name = name;
        this.users = users;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return name;
    }

    public void setRole(String name) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }


}

