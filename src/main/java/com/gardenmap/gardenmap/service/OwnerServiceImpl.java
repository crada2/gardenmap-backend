package com.gardenmap.gardenmap.service;

import com.gardenmap.gardenmap.model.Owner;
import com.gardenmap.gardenmap.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;


@Service
public class OwnerServiceImpl implements OwnerService {

    @Autowired
    private OwnerRepository ownerRepository;

    public OwnerServiceImpl(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public ResponseEntity<Owner> create(@RequestBody Owner owner) {
        Owner savedOwner = ownerRepository.save(owner);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}")
                .buildAndExpand(savedOwner.getId()).toUri();

        return ResponseEntity.created(location).body(savedOwner);
    }

    @Override
    public ResponseEntity<Owner> delete(@PathVariable Long id) {
        Optional<Owner> optionalOwner = ownerRepository.findById(id);

        if (!optionalOwner.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        ownerRepository.delete(optionalOwner.get());
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Page<Owner>> getAll(Pageable pageable) {
        return ResponseEntity.ok(ownerRepository.findAll(pageable));
    }

    @Override
    public ResponseEntity<Owner> getById(@PathVariable Long id) {
        Optional<Owner> optionalOwner = ownerRepository.findById(id);

        if (!optionalOwner.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }
        return ResponseEntity.ok(optionalOwner.get());
    }

    @Override
    public ResponseEntity<Owner> update(@PathVariable Long id, @RequestBody Owner owner) {
        Optional<Owner> optionalOwner = ownerRepository.findById(id);
        if (!optionalOwner.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        owner.setId(optionalOwner.get().getId());
        ownerRepository.save(owner);

        return ResponseEntity.noContent().build();
    }

}
