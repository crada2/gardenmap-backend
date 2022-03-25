package com.gardenmap.gardenmap.service;

import com.gardenmap.gardenmap.auth.facade.IAuthenticationFacade;
import com.gardenmap.gardenmap.model.Product;
import com.gardenmap.gardenmap.model.User;
import com.gardenmap.gardenmap.repository.UserRepository;
import com.gardenmap.gardenmap.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service

public class ProductServiceImpl implements ProductService {

    @Autowired
    private IAuthenticationFacade authenticateUser;
    private ProductRepository productRepository;
    private UserRepository userRepository;

    public ProductServiceImpl(ProductRepository productRepository, UserRepository userRepository) {
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Product create(@RequestBody Product product) {
        var user = authenticateUser.getAuthUser();

        product.setUser(user);
        Product savedProduct = productRepository.save(product);

        return savedProduct;
    }

    @Override
    public boolean delete (@PathVariable Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (!optionalProduct.isPresent()) {
            return false;
        }
        productRepository.delete(optionalProduct.get());
        return true;
    }

    @Override
    public Page<Product> getAll(Pageable pageable) {

        return productRepository.findAll(pageable);
    }

    @Override
    public List<Product> findAllByUser() {
        User user = authenticateUser.getAuthUser();
        return productRepository.findAllByUser(user);
    }

    @Override
    public Product getById(@PathVariable Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (!optionalProduct.isPresent()) {
            return null;
        }
        return optionalProduct.get();
    }

    @Override
    public Product update(@RequestBody Product product, @PathVariable Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);

        if (!optionalProduct.isPresent()) {
            return null;
        }

        product.setId(id);
        product.setUser(optionalProduct.get().getUser());

        return productRepository.save(product);
    }

}
