package com.gardenmap.gardenmap.controller;

import com.gardenmap.gardenmap.model.Product;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {
    @GetMapping("/products/{id}")
    Product getById(@PathVariable Long id){
        return new Product(1L, "title", "description", "direction" ,6.5 );
    }


}
