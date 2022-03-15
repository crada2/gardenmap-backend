package com.gardenmap.gardenmap.service;

import com.gardenmap.gardenmap.model.Owner;
import com.gardenmap.gardenmap.model.Product;
import com.gardenmap.gardenmap.repository.OwnerRepository;
import com.gardenmap.gardenmap.repository.ProductRepository;
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

public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    private OwnerRepository ownerRepository;

    @Override
    public ResponseEntity<Product> create(@RequestBody Product product) {
        Optional<Owner> optionalOwner = ownerRepository.findById(1L);
        if (!optionalOwner.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }
        product.setOwner(optionalOwner.get());

        Product savedProduct = productRepository.save(product);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedProduct.getId()).toUri();
        return ResponseEntity.created(location).body(savedProduct);
    }

    @Override
    public ResponseEntity<Product> delete (@PathVariable Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (!optionalProduct.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }
        productRepository.delete(optionalProduct.get());

        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Page<Product>> getAll(Pageable pageable) {

        return ResponseEntity.ok(productRepository.findAll(pageable));
    }

    @Override
    public ResponseEntity<Product> getById(@PathVariable Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (!optionalProduct.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        return ResponseEntity.ok(optionalProduct.get());
    }

    @Override
    public ResponseEntity<Product> update(@RequestBody Product product, @PathVariable Long id) {
        Optional<Owner> optionalOwner = ownerRepository.findById(1L);
        if (!optionalOwner.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        Optional<Product> optionalProduct = productRepository.findById(id);
        if (!optionalProduct.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        product.setOwner(optionalOwner.get());
        product.setId(optionalProduct.get().getId());
        productRepository.save(product);

        return ResponseEntity.noContent().build();
    }

}
