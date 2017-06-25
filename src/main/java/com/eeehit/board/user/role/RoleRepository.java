package com.eeehit.board.user.role;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by trinity on 17. 5. 17.
 */
public interface RoleRepository extends CrudRepository<Role, Long> {

    Role save(Role role);
}