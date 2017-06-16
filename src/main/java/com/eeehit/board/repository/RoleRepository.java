package com.eeehit.board.repository;

import com.eeehit.board.domain.Role;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by trinity on 17. 5. 17.
 */
public interface RoleRepository extends CrudRepository<Role, Long> {

    Role save(Role role);
}