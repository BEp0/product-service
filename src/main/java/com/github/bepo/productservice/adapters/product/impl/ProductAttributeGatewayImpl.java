package com.github.bepo.productservice.adapters.product.impl;

import com.github.bepo.productservice.adapters.product.ProductAttributeRepository;
import com.github.bepo.productservice.core.domain.Product;
import com.github.bepo.productservice.core.domain.ProductAttribute;
import com.github.bepo.productservice.core.gateway.product.ProductAttributeGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductAttributeGatewayImpl implements ProductAttributeGateway {

    private final ProductAttributeRepository productAttributeRepository;

    @Override
    public ProductAttribute findProductAttributeByStoreAndProductId(Long store, Long productId) {
        return productAttributeRepository.findProductAttributeByStoreAndProduct_Id(store, productId);
    }

    @Override
    public boolean existsByStoreAndProductSku(Long store, String sku) {
        return productAttributeRepository.existsByStoreAndProduct_Sku(store, sku);
    }

    @Override
    public Product findById(Long id) {
        return null;
    }

    @Override
    public void save(ProductAttribute data) {
    }
}
