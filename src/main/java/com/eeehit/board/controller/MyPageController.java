package com.eeehit.board.controller;

import com.eeehit.board.domain.Role;
import com.eeehit.board.domain.User;
import com.eeehit.board.service.RoleService;
import com.eeehit.board.service.UserService;
import com.eeehit.board.session.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Set;

/**
 * Created by trinity on 17. 6. 12.
 */
@Controller
@RequestMapping("myPage")
public class MyPageController {
    @Autowired
    UserService userService;

    @Autowired
    SessionFactory sessionFactory;

    @Autowired
    RoleService roleService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView myPage(HttpSession httpSession){
        ModelAndView mv = new ModelAndView("myPage");
        User user = sessionFactory.getSession(httpSession).getUser();
        Set<Role> roles = sessionFactory.getSession(httpSession).getUser().getRoles();
        String rolesString = sessionFactory.sessionRoles(roles);
        mv.addObject("user", user);
        mv.addObject("roles", rolesString);
        return mv;
    }
}
