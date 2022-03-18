package com.gardenmap.gardenmap.repository;

import com.gardenmap.gardenmap.model.Owner;
import com.gardenmap.gardenmap.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ProductRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;
    OwnerRepository ownerRepository;
    ProductRepository productRepository;

    @Test
    void findByOwnerReturnAnOwnerProductList() {
        var user = new Owner();
        var owner = new Owner();
        var product = new Product();
        product.setOwner(owner);

        entityManager.persist(owner);
        entityManager.persist(product);
        entityManager.flush();


    }

}