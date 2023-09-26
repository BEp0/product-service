package com.github.bepo.productservice.core.dto;

import java.math.BigDecimal;


public record ProductDTO(String sku, BigDecimal price, Long store, Long quantity, boolean available) {
}
