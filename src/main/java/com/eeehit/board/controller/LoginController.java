package com.eeehit.board.controller;

import com.eeehit.board.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * Created by trinity on 17. 5. 18.
 */
@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public ModelAndView LoginPage(){
        return new ModelAndView("login");
    }

    @RequestMapping(value = "login/process", method = RequestMethod.POST)
    public ModelAndView login(
            @RequestParam(value = "userId", required = true) String userId,
            @RequestParam(value = "userPw", required = true) String userPw,
            HttpSession httpSession){

        boolean login_success = this.userService.login(userId, userPw);

        if(login_success == true) {
            httpSession.setAttribute("userId", userId);
            return new ModelAndView("redirect:/");
        } else {
            return new ModelAndView("redirect:/login");
        }
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public ModelAndView Logout(HttpSession httpSession){
        httpSession.invalidate();
        return new ModelAndView("redirect:/");
    }
}
