package org.example.ordermanagement.service;

import org.example.ordermanagement.model.Product;
import org.example.ordermanagement.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public void createProduct(Product product) {
        productRepository.save(product);
    }

    public Long getProductPrice(Long id) {
        return productRepository.getProductPrice(id);
    }
    public List<Long> getProductIds() {
        List<Long> productIds = new ArrayList<>();
        for (Product product : getAllProducts()) {
            productIds.add(product.getId());
        }
        return productIds;
    }

}
