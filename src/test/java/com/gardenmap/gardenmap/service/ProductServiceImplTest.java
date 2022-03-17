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
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;

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

    @Test
    void ProductServiceCantGetAllProducts() {
        var listProducts = List.of(new Product(), new Product());
        Page<Product> productPage = new PageImpl<>(listProducts);

        Mockito.when(productRepository.findAll(productPage.getPageable())).thenReturn(productPage);
        var productService = new ProductServiceImpl(productRepository, ownerRepository);
        var sut = productService.getAll(productPage.getPageable());
        //verify(productRepository, atLeast(1)).findAll();

        assertEquals(sut, productPage);

    }

     /*

  @Test
    void ProductServiceCantUpdateAProduct() {

      Product product = new Product();

      Mockito.when(productRepository.findById(1L)).thenReturn(Optional.of(product));
      productRepository.save(product);

      Product updatedProduct = productRepository.findById();

      assertThat(updatedProduct.getPrice()).isEqualTo();


        Product product = new Product();

        Mockito.when(productRepository.findById(1L)).thenReturn(Optional.of(product));
        Mockito.when(productRepository.save(product)).thenReturn(product);

        var productService = new ProductServiceImpl(productRepository, ownerRepository);
        var sut = productService.update(product, 1L);

        assertEquals(sut, product);
    }
*/

}