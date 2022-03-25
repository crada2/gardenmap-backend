package com.gardenmap.gardenmap.auth.configuration;

import com.gardenmap.gardenmap.model.Role;
import com.gardenmap.gardenmap.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class RoleRepositoryInitializer {

    private RoleRepository roleRepository;

    @Autowired
    public RoleRepositoryInitializer(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @PostConstruct
    public void addAvailableRoles(){
        if (!roleRepository.findAll().isEmpty()) {
            return;
        }

        List<Role> roles = List.of(
                new Role(1, Role.RoleName.ROLE_ADMIN),

                new Role(3, Role.RoleName.ROLE_USER)
        );

        roleRepository.saveAll(roles);
    }
}
