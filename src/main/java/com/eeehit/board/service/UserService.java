package com.eeehit.board.service;

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

    public User getUserById(String id){
        return this.userRepository.findById(id);
    }

    public Boolean login(String id, String pw) {
        User user = this.userRepository.findById(id);
        if ((user.getPw().equals(pw))) return true;
        return false;
    }

    public User join(String id, String pw) {
        return this.userRepository.save(new User(id, pw));
    }
}
