package com.eeehit.board.user.session;

import com.eeehit.board.user.role.Role;
import com.eeehit.board.user.user.User;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by trinity on 17. 6. 15.
 */
@Service
public class SessionService {
    public void makeSession (User loginUser, HttpSession httpSession){
        Session session = new Session(loginUser, httpSession.getCreationTime());
        httpSession.setAttribute("id", session.getUser().getId());
        httpSession.setAttribute("roles", sessionRoles(session.getUser().getRoles()));
        httpSession.setAttribute("loginTime", session.getLoginTime());
    }

    public Session getSession (HttpSession httpSession){
        String id = (String) httpSession.getAttribute("id");
        String roles = (String) httpSession.getAttribute("roles");
        long loginTime = httpSession.getCreationTime();
        return new Session(new User(id, (HashSet) toHashSet(roles)), loginTime);
    }

    public String sessionRoles(Set<Role> roles) {
        String delimiter = ",";
        String roleString = "";

        Iterator<Role> role = roles.iterator();
        while(role.hasNext()) {
            String roleName = role.next().getName();
            if(roleName!=null) {
                roleString += roleName;
                roleString += delimiter;
            }
        }

        return roleString;
    }
    private Set<Role> toHashSet(String sessionRoles) {
        String delimiter = ",";
        String[] roleNameList = sessionRoles.split(delimiter);
        Set<Role> rolesList = new HashSet<>();
        
        for(int i=0 ; i<roleNameList.length ; i++) {
            Role role = new Role(roleNameList[i]);
            rolesList.add(role);
        }
        return rolesList;
    }
}
