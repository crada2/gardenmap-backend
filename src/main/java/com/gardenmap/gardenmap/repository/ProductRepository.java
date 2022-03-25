package com.gardenmap.gardenmap.repository;

import com.gardenmap.gardenmap.model.Product;
import com.gardenmap.gardenmap.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByUser(User user);
}
