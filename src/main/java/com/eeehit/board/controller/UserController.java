package com.eeehit.board.controller;

import com.eeehit.board.domain.User;
import com.eeehit.board.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by trinity on 17. 5. 18.
 */
@RestController
@RequestMapping("v1/user" )
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "id/{id}", method = RequestMethod.GET)
    public User getUserById(@PathVariable(value = "id", required = true) long id){
        return this.userService.getUserById(id);
    }

    @RequestMapping(value = "userId/{userId}", method = RequestMethod.GET)
    public User getUserByUserId(@PathVariable(value = "userId", required = true) String userId){
        return this.userService.getUserByUserId(userId);
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public Boolean login(@RequestParam(value = "userId", required = true) String userId, @RequestParam(value = "userPw", required = true) String userPw) {
        return this.userService.login(userId, userPw);
    }

    @RequestMapping(value = "join", method = RequestMethod.POST)
    public User join(@RequestParam(value = "userId", required = true) String userId, @RequestParam(value = "userPw", required = true) String userPw) {
        return this.userService.join(userId, userPw);
    }
}
