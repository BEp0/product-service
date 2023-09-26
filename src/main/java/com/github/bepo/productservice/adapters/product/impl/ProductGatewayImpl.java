package com.github.bepo.productservice.adapters.product.impl;

import com.github.bepo.productservice.adapters.product.ProductRepository;
import com.github.bepo.productservice.core.domain.Product;
import com.github.bepo.productservice.core.gateway.product.ProductGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductGatewayImpl implements ProductGateway {

    private final ProductRepository productRepository;

    @Override
    public Product findProductBySku(String sku) {
        return null;
    }

    @Override
    public boolean existsBySku(String sku) {
        return false;
    }

    @Override
    public Product findById(Long id) {
        return null;
    }

    @Override
    public void save(Product data) {
    }
}
