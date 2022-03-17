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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ProductServiceImplTest {

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

    @Test
    void ProductServiceCanDeleteAProduct() {
        Product product = new Product();

        Mockito.when(productRepository.findById(1L)).thenReturn(Optional.of(product));

        var productService = new ProductServiceImpl(productRepository, ownerRepository);
        var sut= productService.delete(1L);

        assertTrue(sut);
    }

    @Test
    void ProductServiceCantDeleteWhenProductDoesNotExist() {
        Product product = new Product();

        Mockito.when(productRepository.findById(1L)).thenReturn(Optional.empty());

        var productService = new ProductServiceImpl(productRepository, ownerRepository);
        var sut= productService.delete(1L);

        assertFalse(sut);
    }

    @Test
    void ProductServiceCantGetAProductById() {
        Product product = new Product();

        Mockito.when(productRepository.findById(1L)).thenReturn(Optional.of(product));
        var productService = new ProductServiceImpl(productRepository, ownerRepository);
        var sut = productService.getById(1L);

        assertEquals(sut, product);
    }

   /* @Test
    void ProductServiceCantUpdateAProduct() {
        Product product = new Product();
        var newOwner = new Owner();

        Mockito.when(productRepository.save(product)).thenReturn(product);
        Mockito.when(ownerRepository.findById(1L)).thenReturn(Optional.of(newOwner));

        var productService = new ProductServiceImpl(productRepository, ownerRepository);
        var sut = productService.update(product, 1L);

        assertEquals(sut, product);
    }*/


}