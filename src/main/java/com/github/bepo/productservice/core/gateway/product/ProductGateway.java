package com.github.bepo.productservice.core.gateway.product;

import com.github.bepo.productservice.core.domain.Product;
import com.github.bepo.productservice.core.gateway.DefaultGateway;

public interface ProductGateway extends DefaultGateway<Product, Long> {
    Product findProductBySku(String sku);
    boolean existsBySku(String sku);
}
