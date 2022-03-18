package com.gardenmap.gardenmap.repository;

import com.gardenmap.gardenmap.model.Owner;
import com.gardenmap.gardenmap.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
class OwnerRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;
    OwnerRepository ownerRepository;

    @Test
    void findByOwnerReturnAnOwnerProductList() {
        var owner = new Owner();
        var product = new Product();
        product.setOwner(owner);

        entityManager.persist(owner);
        entityManager.persist(product);
        entityManager.flush();

    }

}