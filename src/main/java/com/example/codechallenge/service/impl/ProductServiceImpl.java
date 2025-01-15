package com.example.codechallenge.service.impl;

import com.example.codechallenge.dto.ProductDTO;
import com.example.codechallenge.entity.Product;
import com.example.codechallenge.repository.ProductRepository;
import com.example.codechallenge.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public Product saveProduct(ProductDTO request) {
        Product product = new Product();
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setStock(request.getStock());
        return productRepository.save(product);
    }

    @Override
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }
}
