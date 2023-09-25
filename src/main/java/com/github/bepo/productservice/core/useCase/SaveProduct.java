package com.github.bepo.productservice.core.useCase;

import java.math.BigDecimal;

public interface SaveProduct {
    void save(String sku, BigDecimal price, Long store, Long quantity, boolean available);
}
