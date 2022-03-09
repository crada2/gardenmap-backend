package com.gardenmap.gardenmap.controller;

import com.gardenmap.gardenmap.model.Owner;
import com.gardenmap.gardenmap.repository.OwnerRepository;
import com.gardenmap.gardenmap.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/owners")
public class OwnerController {
    private final OwnerRepository ownerRepository;
    private final ProductRepository productRepository;


    @Autowired
    public OwnerController(OwnerRepository ownerRepository, ProductRepository productRepository) {
        this.ownerRepository = ownerRepository;
        this.productRepository = productRepository;
    }


    @PostMapping
    public ResponseEntity<Owner> create(@RequestBody Owner owner) {
        Owner savedOwner = ownerRepository.save(owner);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}")
                .buildAndExpand(savedOwner.getId()).toUri();

        return ResponseEntity.created(location).body(savedOwner);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Owner> update(@PathVariable Long id, @RequestBody Owner owner) {
        Optional<Owner> optionalOwner = ownerRepository.findById(id);
        if (!optionalOwner.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        owner.setId(optionalOwner.get().getId());
        ownerRepository.save(owner);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Owner> delete(@PathVariable Long id) {
        Optional<Owner> optionalOwner = ownerRepository.findById(id);

        if (!optionalOwner.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        ownerRepository.delete(optionalOwner.get());
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Owner> getById(@PathVariable Long id) {
        Optional<Owner> optionalOwner = ownerRepository.findById(id);

        if (!optionalOwner.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }
        return ResponseEntity.ok(optionalOwner.get());
    }

    @GetMapping
    public ResponseEntity<Page<Owner>> getAll(Pageable pageable) {
        return ResponseEntity.ok(ownerRepository.findAll(pageable));
    }




}
