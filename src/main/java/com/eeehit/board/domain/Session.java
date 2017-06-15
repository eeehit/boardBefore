package com.eeehit.board.domain;

/**
 * Created by trinity on 17. 6. 6.
 */
public class Session{

    private User user;

    private long loginTime;


    public Session(){}

    public Session(User user, long loginTime) {
        this.user = user;
        this.loginTime = loginTime;
    }


    public User getUser() {
        return user;
    }

    public long getLoginTime() {
        return loginTime;
    }


    public void setUser(User user) {
        this.user = user;
    }

    public void setLoginTime(long loginTime) {
        this.loginTime = loginTime;
    }
}
