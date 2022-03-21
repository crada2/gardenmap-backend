package com.gardenmap.gardenmap.service;

import com.gardenmap.gardenmap.model.User;
import com.gardenmap.gardenmap.repository.UserRepository;
import com.gardenmap.gardenmap.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceImplTest {

    @BeforeEach
    void setUp() {
    }

    @Mock
    ProductRepository productRepository;
    @Mock
    UserRepository userRepository;

    @Test
    void UserServiceCanCreateAUser() {
        User user = new User();

        Mockito.when(userRepository.save(user)).thenReturn(user);

        var ownerService = new UserServiceImpl(userRepository, productRepository);
        var sut = ownerService.create(user);

        assertEquals(sut, user);
    }

    @Test
    void UserServiceCanDeleteAUser() {
        User user = new User();

        Mockito.when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        var userService = new UserServiceImpl(userRepository, productRepository);
        var sut = userService.delete(1L);

        assertTrue(sut);
    }

    @Test
    void UserServiceCantDeleteAOwnerIfTheUserDoesNotExist() {

        Mockito.when(userRepository.findById(1L)).thenReturn(Optional.empty());

        var userService = new UserServiceImpl(userRepository, productRepository);
        var sut = userService.delete(1L);

        assertFalse(sut);
    }

    @Test
    void UserServiceCantGetAllUsers() {
        var listUsers = List.of(new User(), new User());
        Page<User> userPage = new PageImpl<>(listUsers);

        Mockito.when(userRepository.findAll(userPage.getPageable())).thenReturn(userPage);
        var userService = new UserServiceImpl(userRepository, productRepository);
        var sut = userService.getAll(userPage.getPageable());
        //verify(productRepository, atLeast(1)).findAll();

        assertEquals(sut, userPage);

    }

    @Test
    void UserServiceCantUpdateAUser() {
        User user = new User();

        Mockito.when(userRepository.findById(2L)).thenReturn(Optional.of(user));
        Mockito.when(userRepository.save(user)).thenReturn(user);

        user.setId(2L);

        var userService = new UserServiceImpl(userRepository, productRepository);

        var sut = userService.update(user, 2L);

        assertEquals(sut, user);
    }

}
