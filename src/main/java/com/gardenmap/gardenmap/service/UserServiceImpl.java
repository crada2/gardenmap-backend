package com.gardenmap.gardenmap.service;

import com.gardenmap.gardenmap.auth.facade.IAuthenticationFacade;
import com.gardenmap.gardenmap.model.User;
import com.gardenmap.gardenmap.repository.ProductRepository;
import com.gardenmap.gardenmap.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private IAuthenticationFacade authenticateUser;
    @Autowired
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository, ProductRepository productRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(@RequestBody User user) {
        User savedUser = userRepository.save(user);

        return savedUser;
    }

    @Override
    public boolean delete(@PathVariable Long id) {
        Optional<User> optionalUser = userRepository.findById(id);

        if (!optionalUser.isPresent()) {
            return false;
        }

        userRepository.delete(optionalUser.get());
        return true;
    }

    @Override
    public Page<User> getAll(Pageable pageable) {

        return userRepository.findAll(pageable);
    }

    @Override
    public User getById(@PathVariable Long id) {
        Optional<User> optionalUser = userRepository.findById(id);

        if (!optionalUser.isPresent()) {
            return null;
        }
        return optionalUser.get();
    }

    @Override
    public User update(@RequestBody User user, @PathVariable Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (!optionalUser.isPresent()) {
            return null;
        }

        user.setId(optionalUser.get().getId());

        return userRepository.save(user);
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User getAuthenticatedUser() {
        User user = authenticateUser.getAuthUser();
        return user;
    }
}
