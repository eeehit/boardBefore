package com.eeehit.board.service;

import com.eeehit.board.domain.Role;
import com.eeehit.board.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by trinity on 17. 5. 18.
 */
@Service
public class RoleService {

    @Autowired
    RoleRepository roleRepository;

    public Role addRole(String roleName) {
        return roleRepository.save(new Role(roleName));
    }

    public List<Role> myPageRole(Set<Role> roles) {
        return (ArrayList)roles;
    }
}
