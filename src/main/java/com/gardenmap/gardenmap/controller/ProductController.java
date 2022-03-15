package com.gardenmap.gardenmap.controller;

import com.gardenmap.gardenmap.model.Owner;
import com.gardenmap.gardenmap.model.Product;
import com.gardenmap.gardenmap.service.OwnerService;
import com.gardenmap.gardenmap.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/products")

public class ProductController {
    private final ProductService productService;
    private final OwnerService ownerService;

    @Autowired
    public ProductController(ProductService productService, OwnerService ownerService) {
        this.productService = productService;
        this.ownerService = ownerService;
    }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product product) {
       var savedProduct = productService.create(product);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedProduct.getId()).toUri();

        return ResponseEntity.created(location).body(savedProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> delete (@PathVariable Long id) {

        return productService.delete(id);
    }

    @GetMapping
    public ResponseEntity<Page<Product>> getAll(Pageable pageable) {

        return productService.getAll(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable Long id) {

        return productService.getById(id);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@RequestBody Product product, @PathVariable Long id) {
        Optional<Owner> optionalOwner = ownerService.findById(product.getOwner().getId());

        return productService.update(product, id);
    }




}
