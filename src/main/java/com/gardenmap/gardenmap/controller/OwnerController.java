package com.gardenmap.gardenmap.controller;

import com.gardenmap.gardenmap.model.Owner;
import com.gardenmap.gardenmap.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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

        return ownerService.create(owner);
    }

    @GetMapping
    public ResponseEntity<Page<Owner>> getAll(Pageable pageable) {

        return ownerService.getAll(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Owner> getById(@PathVariable Long id) {

        return ownerService.getById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Owner> delete(@PathVariable Long id) {

        return ownerService.delete(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Owner> update(@PathVariable Long id, @RequestBody Owner owner) {

        return ownerService.update(id, owner);
    }



}
