package com.gardenmap.gardenmap.controller;

import com.gardenmap.gardenmap.model.User;
import com.gardenmap.gardenmap.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;


@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;


    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user) {

       User savedUser=  userService.create(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}")
        .buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).body(savedUser);
    }

    @GetMapping
    public ResponseEntity<Page<User>> getAll(Pageable pageable) {
        Page<User> page = userService.getAll(pageable);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable Long id) {
        User user = userService.getById(id);
        if (user == null){
            return ResponseEntity.unprocessableEntity().build();
        }
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> delete(@PathVariable Long id) {
        boolean isDelete = userService.delete(id);
        if (!isDelete) {
            return ResponseEntity.unprocessableEntity().build();
        }
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@RequestBody User user, @PathVariable Long id) {
        User updatedUser = userService.update(user, id);
        if (user == null){
            return ResponseEntity.unprocessableEntity().build();
        }
        return ResponseEntity.ok(updatedUser);
    }



}
