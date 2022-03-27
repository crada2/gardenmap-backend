/*package com.gardenmap.gardenmap.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.gardenmap.gardenmap.model.Product;
import com.gardenmap.gardenmap.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
class ProductRepositoryTest {

    @Autowired
    TestEntityManager entityManager;
    ProductRepository productRepository;


    @Test
    void findAll() {
        Product product = new Product();
        entityManager.persist(product);
        entityManager.flush();
        assertEquals(1, productRepository.findAll().size());
    }

    @Test
    void FindAllProductsReturnsAnAllProductsList() {
        Product product = new Product();
        entityManager.persist(product);
        entityManager.flush();

        assertEquals(1, productRepository.findAll().size());
        assertEquals(product, productRepository.findAll().get(8));
    }

    @Test
    void FindAllProductsByUser() {
        User user = new User();
        Product product = new Product();
        product.setUser(user);
        entityManager.persist(user);
        entityManager.persist(product);
        entityManager.flush();

        var sut = productRepository.findAllByUser(user);

        assertEquals(1, sut.size());

    }

}*/