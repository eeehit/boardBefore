package com.eeehit.board.user.user;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by trinity on 17. 5. 17.
 */
public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findAll();

    User findById(String id);

    User save(User user);
}