package com.gardenmap.gardenmap.Controller;


import com.gardenmap.gardenmap.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @GetMapping("/products/{id}")
    Product getById(@PathVariable){

    }
}
