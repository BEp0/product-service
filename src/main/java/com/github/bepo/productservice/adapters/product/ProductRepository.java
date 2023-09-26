package com.github.bepo.productservice.adapters.product;

import com.github.bepo.productservice.core.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findProductBySku(String sku);
    boolean existsBySku(String sku);
}
