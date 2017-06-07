package com.eeehit.board.service;

import com.eeehit.board.domain.Role;
import com.eeehit.board.domain.User;
import com.eeehit.board.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by trinity on 17. 5. 18.
 */
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> getUserList(){
        return this.userRepository.findAll();
    }

    public User getUserByUserId(String userId){
        return this.userRepository.findByUserId(userId);
    }

    public Boolean login(String userId, String userPw) {
        User user = this.userRepository.findByUserId(userId);
        if ((user.getUserPw().equals(userPw))) {
            return true;
        }
        return false;
    }

    public User join(String userId, String userPw, Role role) {
        return this.userRepository.save(new User(userId, userPw, role));
    }
}
