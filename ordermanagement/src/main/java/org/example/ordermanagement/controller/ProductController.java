package org.example.ordermanagement.controller;

import org.example.ordermanagement.model.Product;
import org.example.ordermanagement.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getProducts() {
        return productService.getProducts();
    }
    @PostMapping
    public void addProduct(@RequestBody Product product) {
        productService.addProduct(product);
    }




}
