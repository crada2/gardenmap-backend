package com.gardenmap.gardenmap.service;

import com.gardenmap.gardenmap.model.Owner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface OwnerService {

    ResponseEntity<Owner> create(Owner owner);
    ResponseEntity<Owner> delete(Long id);
    ResponseEntity<Page<Owner>> getAll(Pageable pageable);
    ResponseEntity<Owner> getById(Long id);
    ResponseEntity<Owner> update(Long id, Owner owner);

    Optional<Owner> findById(Long id);
}
