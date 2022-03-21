package com.gardenmap.gardenmap.auth.facade;

import com.gardenmap.gardenmap.model.User;
import com.gardenmap.gardenmap.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component

public class AuthenticationFacade {
    @Autowired
    UserRepository userRepository;

    public User getAuthUser() {
        var userName = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findByUsername(userName).get();
    }

}
