package com.gardenmap.gardenmap.service;

import com.gardenmap.gardenmap.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface UserService {
    User create(User user);
    boolean delete(Long id);
    Page<User> getAll(Pageable pageable);
    User getById(Long id);
    User update(User user, Long id);
    User getAuthenticatedUser();
    Optional<User> findById(Long id);
}
