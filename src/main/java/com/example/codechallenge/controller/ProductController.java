package com.example.codechallenge.controller;

import com.example.codechallenge.dto.ProductDTO;
import com.example.codechallenge.entity.Product;
import com.example.codechallenge.exceptions.ProductNotFoundException;
import com.example.codechallenge.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Product product = productService.getProductById(id)
                .orElseThrow(() -> new ProductNotFoundException("El producto con el ID: " + id + ", no se ha encontrado"));
        return ResponseEntity.ok(product);
    }

    @PostMapping("/save")
    public ResponseEntity<String> save(@Valid @RequestBody ProductDTO product) {
        productService.saveProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body("¡El producto se agregó correctamente!");
    }
}
