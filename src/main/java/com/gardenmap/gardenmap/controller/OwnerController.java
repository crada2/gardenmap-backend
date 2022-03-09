/*package com.gardenmap.gardenmap.controller;

import com.gardenmap.gardenmap.model.Owner;
import com.gardenmap.gardenmap.repository.OwnerRepository;
import com.gardenmap.gardenmap.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/owners")
public class OwnerController {
    @Autowired
    OwnerRepository ownerRepository;

    @Autowired
    ProductRepository productRepository;

    @PostMapping
    public ResponseEntity<Owner> create(@RequestBody Owner owner) {
        Owner savedOwner = ownerRepository.save(owner);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}")
                .buildAndExpand(savedOwner.getId()).toUri();

        return ResponseEntity.created(location).body(savedOwner);
    }
}*/
