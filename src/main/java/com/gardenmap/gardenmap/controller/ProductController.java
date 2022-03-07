package com.gardenmap.gardenmap.controller;

import com.gardenmap.gardenmap.dtos.ProductResponseDTO;
import com.gardenmap.gardenmap.model.Product;
import com.gardenmap.gardenmap.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductRepository productRepository;
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

}
