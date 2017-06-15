package com.eeehit.board.session;

import com.eeehit.board.domain.Role;
import com.eeehit.board.domain.Session;
import com.eeehit.board.domain.User;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

/**
 * Created by trinity on 17. 6. 15.
 */
@Service
public class SessionFactory {
    public void makeSession (User loginUser, HttpSession httpSession){
        Session session = new Session(loginUser, httpSession.getCreationTime());

        httpSession.setAttribute("key", session.getUser().getKey());
        httpSession.setAttribute("id", session.getUser().getId());
        httpSession.setAttribute("pw", session.getUser().getPw());
        httpSession.setAttribute("role", session.getUser().getRole());
        httpSession.setAttribute("loginTime", session.getLoginTime());
    }

    public Session getSession (HttpSession httpSession){
        long key = (long) httpSession.getAttribute("key");
        String id = (String) httpSession.getAttribute("id");
        String pw = (String) httpSession.getAttribute("pw");
        Role role = (Role) httpSession.getAttribute("role");
        long loginTime = httpSession.getCreationTime();
        Session session = new Session(new User(key, id, pw, role), loginTime);
        return session;
    }
}
