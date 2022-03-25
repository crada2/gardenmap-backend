/*package com.gardenmap.gardenmap.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.gardenmap.gardenmap.model.Product;
import com.gardenmap.gardenmap.model.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
class ProductRepositoryTest {

    @Autowired
    TestEntityManager entityManager;
    ProductRepository productRepository;
    RoleRepository roleRepository;


    @Test
    void findByUserReturnAnOwnerProductList() {
        var role = new Role();
        entityManager.persist(role);
        entityManager.flush();

        assertEquals(roleRepository.findByName(Role.RoleName).size());
        assertEquals(role, roleRepository.findByName(Role.RoleName).get());
    }

}

 */