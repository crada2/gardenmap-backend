package com.gardenmap.gardenmap.service;

import com.gardenmap.gardenmap.model.Owner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface OwnerService {

    ResponseEntity<Owner> create(Owner owner);
    ResponseEntity<Owner> delete(Long id);
    ResponseEntity<Page<Owner>> getAll(Pageable pageable);
    ResponseEntity<Owner> getById(Long id);
    ResponseEntity<Owner> update(Long id, Owner owner);
}
