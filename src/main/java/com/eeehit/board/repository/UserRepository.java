package com.eeehit.board.repository;

import com.eeehit.board.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by trinity on 17. 5. 17.
 */
public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findAll();

    User findByUserId(String userId);

    User save(User user);
}