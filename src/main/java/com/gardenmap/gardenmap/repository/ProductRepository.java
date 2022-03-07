package com.gardenmap.gardenmap.repository;

import com.gardenmap.gardenmap.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
