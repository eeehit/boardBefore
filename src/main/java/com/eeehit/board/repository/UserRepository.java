package com.eeehit.board.repository;

import com.eeehit.board.domain.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by trinity on 17. 5. 17.
 */
public interface UserRepository extends CrudRepository<User, Long> {

    User findById(long id);

    User findByUserId(String userId);

    User save(User user);
}