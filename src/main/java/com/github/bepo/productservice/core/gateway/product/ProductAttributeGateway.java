package com.github.bepo.productservice.core.gateway.product;

import com.github.bepo.productservice.core.domain.ProductAttribute;
import com.github.bepo.productservice.core.gateway.DefaultGateway;

public interface ProductAttributeGateway extends DefaultGateway<ProductAttribute, Long> {
    ProductAttribute findProductAttributeByStoreAndProductId(Long store, Long productId);
    boolean existsByStoreAndProductSku(Long store, String sku);
}
