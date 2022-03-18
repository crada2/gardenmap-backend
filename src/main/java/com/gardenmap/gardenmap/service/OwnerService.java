package com.gardenmap.gardenmap.service;

import com.gardenmap.gardenmap.model.Owner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface OwnerService {

    Owner create(Owner owner);
    boolean delete(Long id);
    Page<Owner> getAll(Pageable pageable);
    Owner getById(Long id);
    Owner update(Owner owner, Long id);

    Optional<Owner> findById(Long id);
}
