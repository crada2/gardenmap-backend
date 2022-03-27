package com.gardenmap.gardenmap.service;

import com.gardenmap.gardenmap.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    Product create(Product product);
    boolean delete (Long id);
    Page<Product> getAll(Pageable pageable);
    Product getById(Long id);
    Product update(Product product, Long id);
    List<Product> findAllByUser();
}
