package com.gardenmap.gardenmap.service;

import com.gardenmap.gardenmap.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface ProductService {
    ResponseEntity<Product> create(Product product);
    ResponseEntity<Product> delete (Long id);
    ResponseEntity<Page<Product>> getAll(Pageable pageable);
    ResponseEntity<Product> getById(Long id);
    ResponseEntity<Product> update(Product product, Long id);
}
