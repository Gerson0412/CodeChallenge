package com.example.codechallenge.service;

import com.example.codechallenge.dto.ProductDTO;
import com.example.codechallenge.entity.Product;

import java.util.Optional;

public interface ProductService {
    Product saveProduct(ProductDTO product);

    Optional<Product> getProductById(Long id);
}
