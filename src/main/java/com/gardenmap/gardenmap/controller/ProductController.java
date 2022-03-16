package com.gardenmap.gardenmap.controller;

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
        Product savedProduct = productService.create(product);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedProduct.getId()).toUri();

        return ResponseEntity.created(location).body(savedProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> delete (@PathVariable Long id) {
        boolean deleted = productService.delete(id);
        if (!deleted) {
            return ResponseEntity.unprocessableEntity().build();
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<Page<Product>> getAll(Pageable pageable) {
        Page<Product> page = productService.getAll(pageable);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable Long id) {
        Product product = productService.getById(id);
        if (product == null) {
            return ResponseEntity.unprocessableEntity().build();
        }
        return ResponseEntity.ok(product);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@RequestBody Product product, @PathVariable Long id) {
        Product updatedProduct = productService.update(product, id);
        if (product == null) {
            return ResponseEntity.unprocessableEntity().build();
        }
        return ResponseEntity.ok(updatedProduct);
    }




}
