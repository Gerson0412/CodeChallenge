package com.example.codechallenge.controller;

import com.example.codechallenge.dto.ProductDTO;
import com.example.codechallenge.entity.Product;
import com.example.codechallenge.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {
    @Mock
    private ProductService productService;

    @Test
    public void testGetProductById_Success() {
        Long productId = 1L;
        Product mockProduct = new Product();
        mockProduct.setIdProduct(productId);
        mockProduct.setDescription("Gaseosa Inka kola");
        when(productService.getProductById(productId)).thenReturn(Optional.of(mockProduct));

        Optional<Product> result = productService.getProductById(productId);

        assertTrue(result.isPresent());
        assertEquals("Gaseosa Inka kola", result.get().getDescription());
        verify(productService, times(1)).getProductById(productId);
    }

    @Test
    public void testGetProductById_NotFound() {
        Long productId = 1L;
        when(productService.getProductById(productId)).thenReturn(Optional.empty());

        Optional<Product> result = productService.getProductById(productId);

        assertFalse(result.isPresent());
        verify(productService, times(1)).getProductById(productId);
    }
}