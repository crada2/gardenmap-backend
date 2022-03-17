package com.gardenmap.gardenmap.service;

import com.gardenmap.gardenmap.model.Owner;
import com.gardenmap.gardenmap.model.Product;
import com.gardenmap.gardenmap.repository.OwnerRepository;
import com.gardenmap.gardenmap.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class OwnerServiceImplTest {

    @BeforeEach
    void setUp() {
    }

    @Mock
    ProductRepository productRepository;
    @Mock
    OwnerRepository ownerRepository;

    @Test
    void ProductServiceCanCreateAProduct() {
        Product product = new Product();
        var newOwner = new Owner();
        Mockito.when(productRepository.save(product)).thenReturn(product);
        Mockito.when(ownerRepository.findById(2L)).thenReturn(Optional.of(newOwner));

        var productService = new ProductServiceImpl(productRepository, ownerRepository);
        var sut = productService.create(product);

        assertEquals(sut, product);
    }

}
