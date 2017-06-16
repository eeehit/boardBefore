package com.eeehit.board.controller;

import com.eeehit.board.domain.User;
import com.eeehit.board.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by trinity on 17. 5. 18.
 */
@RestController
@RequestMapping("admin" )
public class AdminController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "userList", method = RequestMethod.GET)
    public List<User> getUserList() {
        return this.userService.getUserList();
    }

    @RequestMapping(value = "userId/{userId}", method = RequestMethod.GET)
    public User getUserByUserId(@PathVariable(value = "userId", required = true) String id) {
        return this.userService.getUserById(id);
    }

    @RequestMapping(value = "join", method = RequestMethod.POST)
    public User join(
            @RequestParam(value = "userId", required = true) String id,
            @RequestParam(value = "userPw", required = true) String pw) {
        return this.userService.join(id, pw);
    }
}
