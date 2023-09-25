package com.github.bepo.productservice.core.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;


public record ProductDTO(
        @NotBlank
        String sku,
        @NotNull
        BigDecimal price,
        @NotNull
        Long store,
        @NotNull
        Long quantity,
        boolean available) {
}
