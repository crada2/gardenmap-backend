package com.gardenmap.gardenmap.controller;

import com.gardenmap.gardenmap.dtos.ProductResponseDTO;
import com.gardenmap.gardenmap.model.Owner;
import com.gardenmap.gardenmap.model.Product;
import com.gardenmap.gardenmap.repository.OwnerRepository;
import com.gardenmap.gardenmap.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    OwnerRepository ownerRepository;

    private Owner getAuthOwner(){

        return ownerRepository.findById(1L).get();
    }
    
    @GetMapping("/products")
    List<Product> getAll() {
        var product = productRepository.findAll();
        return product;
    }

    @GetMapping("/products/{id}")
    ProductResponseDTO getById(@PathVariable Long id){
        var postOptional = productRepository.findById(id);
        var product = postOptional.get();
        var productDTO = new ProductResponseDTO().mapFromProduct(product);

        return productDTO;
    }
    @PostMapping("/products")
    Product create(@RequestBody Product product) {
        var  authOwner = this.getAuthOwner();
        product.setOwner(authOwner);
        productRepository.save(product);
        return product;
    }
    @GetMapping("/products/owners/{id}")
        List<Product> getAllByOwner(@PathVariable Long id){
        var owner = ownerRepository.findById(id).get();
        return productRepository.findAllByOwner(owner);
    }




}
