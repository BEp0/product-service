package com.github.bepo.productservice.core.repository;

import com.github.bepo.productservice.core.domain.ProductAttribute;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductAttributeRepository extends JpaRepository<ProductAttribute, Long> {
    ProductAttribute findProductAttributeByStoreAndProduct_Id(Long store, Long productId);
    boolean existsByStoreAndProduct_Sku(Long store, String sku);
}
