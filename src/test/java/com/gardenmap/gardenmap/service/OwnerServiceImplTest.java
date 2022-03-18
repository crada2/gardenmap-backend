package com.gardenmap.gardenmap.service;

import com.gardenmap.gardenmap.model.Owner;
import com.gardenmap.gardenmap.repository.OwnerRepository;
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

    @Test
    void OwnerServiceCantDeleteAOwnerIfTheOwnerDoesNotExist() {

        Mockito.when(ownerRepository.findById(1L)).thenReturn(Optional.empty());

        var ownerService = new OwnerServiceImpl(ownerRepository, productRepository);
        var sut = ownerService.delete(1L);

        assertFalse(sut);
    }

    @Test
    void OwnerServiceCantGetAllOwners() {
        var listOwners = List.of(new Owner(), new Owner());
        Page<Owner> ownerPage = new PageImpl<>(listOwners);

        Mockito.when(ownerRepository.findAll(ownerPage.getPageable())).thenReturn(ownerPage);
        var ownerService = new OwnerServiceImpl(ownerRepository, productRepository);
        var sut = ownerService.getAll(ownerPage.getPageable());
        //verify(productRepository, atLeast(1)).findAll();

        assertEquals(sut, ownerPage);

    }

    @Test
    void OwnerServiceCantUpdateAOwner() {
        Owner owner = new Owner();

        Mockito.when(ownerRepository.findById(2L)).thenReturn(Optional.of(owner));
        Mockito.when(ownerRepository.save(owner)).thenReturn(owner);

        owner.setId(2L);

        var ownerService = new OwnerServiceImpl(ownerRepository, productRepository);

        var sut = ownerService.update(owner, 2L);

        assertEquals(sut, owner);
    }

}
