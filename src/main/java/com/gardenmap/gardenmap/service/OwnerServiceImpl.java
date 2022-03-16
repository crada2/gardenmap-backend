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
    public Owner create(@RequestBody Owner owner) {
        Owner savedOwner = ownerRepository.save(owner);

        return savedOwner;
    }

    @Override
    public boolean delete(@PathVariable Long id) {
        Optional<Owner> optionalOwner = ownerRepository.findById(id);

        if (!optionalOwner.isPresent()) {
            return false;
        }

        ownerRepository.delete(optionalOwner.get());
        return true;
    }

    @Override
    public Page<Owner> getAll(Pageable pageable) {

        return ownerRepository.findAll(pageable);
    }

    @Override
    public Owner getById(@PathVariable Long id) {
        Optional<Owner> optionalOwner = ownerRepository.findById(id);

        if (!optionalOwner.isPresent()) {
            return null;
        }
        return optionalOwner.get();
    }

    @Override
    public Owner update(@PathVariable Long id, @RequestBody Owner owner) {
        Optional<Owner> optionalOwner = ownerRepository.findById(id);
        if (!optionalOwner.isPresent()) {
            return null;
        }

        owner.setId(optionalOwner.get().getId());

        return ownerRepository.save(owner);
    }

    @Override
    public Optional<Owner> findById(Long id) {
        return ownerRepository.findById(id);
    }

    }
