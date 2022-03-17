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
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    void OwnerServiceCanCreateAOwner() {
        Owner owner = new Owner();

        Mockito.when(ownerRepository.save(owner)).thenReturn(owner);

        var ownerService = new OwnerServiceImpl(ownerRepository, productRepository);
        var sut = ownerService.create(owner);

        assertEquals(sut, owner);
    }

    @Test
    void OwnerServiceCanDeleteAOwner() {
        Owner owner = new Owner();

        Mockito.when(ownerRepository.findById(1L)).thenReturn(Optional.of(owner));

        var ownerService = new OwnerServiceImpl(ownerRepository, productRepository);
        var sut = ownerService.delete(1L);

        assertTrue(sut);
    }

}
