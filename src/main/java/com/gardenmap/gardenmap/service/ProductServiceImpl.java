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


    private ProductRepository productRepository;
    private OwnerRepository ownerRepository;

    public ProductServiceImpl(ProductRepository productRepository, OwnerRepository ownerRepository) {
        this.productRepository = productRepository;
        this.ownerRepository = ownerRepository;
    }

    @Override
    public Product create(@RequestBody Product product) {
        var owner = ownerRepository.findById(1L).get();
        product.setOwner(owner);
        Product savedProduct = productRepository.save(product);

        return savedProduct;
    }

    @Override
    public boolean delete (@PathVariable Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (!optionalProduct.isPresent()) {
            return false;
        }
        productRepository.delete(optionalProduct.get());
        return true;
    }

    @Override
    public Page<Product> getAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Product getById(@PathVariable Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (!optionalProduct.isPresent()) {
            return null;
        }
        return optionalProduct.get();
    }

    @Override
    public Product update(@RequestBody Product product, @PathVariable Long id) {
        Optional<Owner> optionalOwner = ownerRepository.findById(id);
        if (!optionalOwner.isPresent()) {
            return null;
        }

        Optional<Product> optionalProduct = productRepository.findById(id);
        if (!optionalProduct.isPresent()) {
            return null;
        }

        product.setOwner(optionalOwner.get());
        product.setId(optionalProduct.get().getId());

        return productRepository.save(product);
    }

}
