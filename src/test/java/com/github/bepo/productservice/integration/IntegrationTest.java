package com.github.bepo.productservice.integration;

import com.github.bepo.productservice.core.domain.Product;
import com.github.bepo.productservice.core.domain.ProductAttribute;
import com.github.bepo.productservice.core.repository.ProductAttributeRepository;
import com.github.bepo.productservice.core.repository.ProductRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
@Profile({"test"})
public abstract class IntegrationTest {

    @Autowired
    protected ProductRepository productRepository;

    @Autowired
    private ProductAttributeRepository productAttributeRepository;

    @BeforeEach
    public void doBeforeEach() {
        var product = new Product(null, "00000000", null);
        var attributes = List.of(
                new ProductAttribute(null, product, new BigDecimal(10), 1L, 100L, true),
                new ProductAttribute(null, product, new BigDecimal(11), 2L, 100L, false),
                new ProductAttribute(null, product, new BigDecimal(12), 3L, 100L, true)
        );
        product.setAttributes(attributes);

        productRepository.save(product);
        productAttributeRepository.saveAll(attributes);
    }

    @AfterEach
    public void doAfterEach() {
        productAttributeRepository.deleteAll();
        productRepository.deleteAll();
    }
}
