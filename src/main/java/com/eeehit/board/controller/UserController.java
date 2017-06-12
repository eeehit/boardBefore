package com.eeehit.board.controller;

import com.eeehit.board.domain.User;
import com.eeehit.board.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * Created by trinity on 17. 6. 12.
 */
@Controller
@RequestMapping("myPage")
public class UserController {
    @Autowired
    UserService userService;


    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView myPage(HttpSession httpSession){
        ModelAndView mv = new ModelAndView("myPage");
        String userId = (String) httpSession.getAttribute("userId");
        User user = userService.getUserByUserId(userId);
        mv.addObject("user", user);
        return mv;
    }
}
