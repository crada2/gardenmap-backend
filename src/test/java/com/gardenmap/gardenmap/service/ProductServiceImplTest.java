package com.gardenmap.gardenmap.service;

import com.gardenmap.gardenmap.model.User;
import com.gardenmap.gardenmap.model.Product;
import com.gardenmap.gardenmap.repository.UserRepository;
import com.gardenmap.gardenmap.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;
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
   UserRepository userRepository;

    @Test
    void ProductServiceCanCreateAProduct() {
        Product product = new Product();
        User newUser = new User();

        Mockito.when(productRepository.save(product)).thenReturn(product);
        Mockito.when(userRepository.findById(1L)).thenReturn(Optional.of(newUser));

        var productService = new ProductServiceImpl(productRepository, userRepository);
        var sut = productService.create(product);

        assertEquals(sut, product);
    }

    @Test
    void ProductServiceCanDeleteAProduct() {
        Product product = new Product();

        Mockito.when(productRepository.findById(1L)).thenReturn(Optional.of(product));

        var productService = new ProductServiceImpl(productRepository, userRepository);
        var sut= productService.delete(1L);

        assertTrue(sut);
    }

    @Test
    void ProductServiceCantDeleteWhenProductDoesNotExist() {

        Mockito.when(productRepository.findById(1L)).thenReturn(Optional.empty());

        var productService = new ProductServiceImpl(productRepository, userRepository);
        var sut= productService.delete(1L);

        assertFalse(sut);
    }

    @Test
    void ProductServiceCanGetAProductById() {
        Product product = new Product();

        Mockito.when(productRepository.findById(1L)).thenReturn(Optional.of(product));
        var productService = new ProductServiceImpl(productRepository, userRepository);
        var sut = productService.getById(1L);

        assertEquals(sut, product);
    }

    @Test
    void ProductServiceCantGetAllProducts() {
        var listProducts = List.of(new Product(), new Product());
        Page<Product> productPage = new PageImpl<>(listProducts);

        Mockito.when(productRepository.findAll(productPage.getPageable())).thenReturn(productPage);
        var productService = new ProductServiceImpl(productRepository, userRepository);
        var sut = productService.getAll(productPage.getPageable());

        assertEquals(sut, productPage);

    }

    @Test
    void ProductServiceCantUpdateAProduct() {
        Product product = new Product();
        User user = new User();

        Mockito.when(productRepository.findById(1L)).thenReturn(Optional.of(product));
        Mockito.when(productRepository.save(product)).thenReturn(product);

        product.setUser(user);
        product.setId(2L);

        var productService = new ProductServiceImpl(productRepository,userRepository);

        var sut = productService.update(product, 1L);

        assertEquals(sut, product);
    }
}