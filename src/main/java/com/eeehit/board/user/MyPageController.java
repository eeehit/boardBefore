package com.eeehit.board.user;

import com.eeehit.board.user.role.Role;
import com.eeehit.board.user.role.RoleService;
import com.eeehit.board.user.session.SessionService;
import com.eeehit.board.user.user.User;
import com.eeehit.board.user.user.UserService;
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
    SessionService sessionService;

    @Autowired
    RoleService roleService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView myPage(HttpSession httpSession){
        ModelAndView mv = new ModelAndView("myPage");
        User user = sessionService.getSession(httpSession).getUser();
        Set<Role> roles = sessionService.getSession(httpSession).getUser().getRoles();
        String rolesString = sessionService.sessionRoles(roles);
        mv.addObject("user", user);
        mv.addObject("roles", rolesString);
        return mv;
    }
}
