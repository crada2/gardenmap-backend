/*package com.gardenmap.gardenmap.repository;

import com.gardenmap.gardenmap.model.User;
import com.gardenmap.gardenmap.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;
    UserRepository userRepository;

    @Test
    void findByUserReturnAnUserProductList() {
        var user = new User();
        var product = new Product();
        product.setUser(user);

        entityManager.persist(user);
        entityManager.persist(product);
        entityManager.flush();
    }
}*/