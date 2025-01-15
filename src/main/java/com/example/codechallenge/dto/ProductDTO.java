package com.example.codechallenge.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ProductDTO {
    @NotBlank(message = "Debes ingresar una descripcion")
    private String description;

    @Min(value = 1, message = "El precio debe ser mayor a 0")
    private Double price;

    @Min(value = 1, message = "La cantidad debe ser mayor a 0")
    private int stock;
}
