package com.gardenmap.gardenmap.controller;

import com.gardenmap.gardenmap.model.Owner;
import com.gardenmap.gardenmap.model.Product;
import com.gardenmap.gardenmap.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;


@CrossOrigin
@RestController
@RequestMapping("/owners")
public class OwnerController {
    private final OwnerService ownerService;


    @Autowired
    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @PostMapping
    public ResponseEntity<Owner> create(@RequestBody Owner owner) {

       Owner savedOwner=  ownerService.create(owner);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}")
        .buildAndExpand(savedOwner.getId()).toUri();
        return ResponseEntity.created(location).body(savedOwner);
    }

    @GetMapping
    public ResponseEntity<Page<Owner>> getAll(Pageable pageable) {
        Page<Owner> page = ownerService.getAll(pageable);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Owner> getById(@PathVariable Long id) {
        Owner owner = ownerService.getById(id);
        if (owner == null){
            return ResponseEntity.unprocessableEntity().build();
        }
        return ResponseEntity.ok(owner);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Owner> delete(@PathVariable Long id) {
        boolean isDelete = ownerService.delete(id);
        if (!isDelete) {
            return ResponseEntity.unprocessableEntity().build();
        }
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Owner> update(@RequestBody Owner owner, @PathVariable Long id) {
        Owner updatedOwner = ownerService.update(owner, id);
        if (owner == null){
            return ResponseEntity.unprocessableEntity().build();
        }
        return ResponseEntity.ok(updatedOwner);
    }



}
