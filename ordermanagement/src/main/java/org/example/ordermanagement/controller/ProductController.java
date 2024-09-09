package org.example.ordermanagement.controller;

import org.example.ordermanagement.controller.dto.product.ProductDto;
import org.example.ordermanagement.controller.requestdto.product.ProductRequestDto;
import org.example.ordermanagement.mapper.ProductMapper;
import org.example.ordermanagement.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductMapper productMapper;


    @GetMapping
    public List<ProductDto> getAllProducts() {
        return productMapper.toProductDtoList(productService.getAllProducts());
    }

    @PostMapping
    public void createProduct(@RequestBody ProductRequestDto productRequestDto) {
        productService.createProduct(productMapper.toProduct(productRequestDto));
    }




}
