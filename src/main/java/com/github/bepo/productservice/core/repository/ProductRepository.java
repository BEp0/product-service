package com.github.bepo.productservice.core.repository;

import com.github.bepo.productservice.core.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findProductBySku(String sku);
}
