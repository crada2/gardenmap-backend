package com.gardenmap.gardenmap.auth.facade;

import com.gardenmap.gardenmap.model.User;
import com.gardenmap.gardenmap.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AuthenticationFacade implements IAuthenticationFacade {
    @Autowired
    UserRepository userRepository;

    public User getAuthUser() {
        var userName = SecurityContextHolder.getContext().getAuthentication().getName();

        Optional<User> optionalUser = userRepository.findByUsername(userName);

        if (!optionalUser.isPresent()) {
            return null;
        }
        return optionalUser.get();
    }
}
