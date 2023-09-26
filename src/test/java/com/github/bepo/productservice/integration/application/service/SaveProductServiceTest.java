package com.github.bepo.productservice.integration.application.service;

import com.github.bepo.productservice.application.exception.BadRequestException;
import com.github.bepo.productservice.application.service.SaveProductService;
import com.github.bepo.productservice.core.domain.Product;
import com.github.bepo.productservice.core.dto.ProductDTO;
import com.github.bepo.productservice.integration.IntegrationTest;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class SaveProductServiceTest extends IntegrationTest {

    private final static String SKU = "00000001";
    private final static BigDecimal PRICE = new BigDecimal(11);
    private final static Long STORE = 1L;
    private final static Long QUANTITY = 190L;
    private final static boolean AVAILABLE = true;

    @Autowired
    private SaveProductService saveProductService;

    @Test
    @DisplayName("Should save and mount a product correctly")
    @Transactional
    void saveProduct() {
        var dto = new ProductDTO(SKU, PRICE, STORE, QUANTITY, AVAILABLE);
        saveProductService.save(dto);

        var product = productRepository.findProductBySku(SKU);
        assertNotNull(product);
        assertEquals(3L, product.getId());
        assertEquals(SKU, product.getSku());
        assertAttributes(dto, product);
    }

    @Test
    @DisplayName("Should valid sku in productDTO")
    @Transactional
    void validProduct() {
        var dto = new ProductDTO("", PRICE, STORE, QUANTITY, AVAILABLE);
        var exception = assertThrows(BadRequestException.class, () -> saveProductService.save(dto));
        String messageExpect = "Sku cannot be blank";
        assertTrue(exception.getMessage().contains(messageExpect));
    }

    public void assertAttributes(ProductDTO expected, Product product) {
        var exists = product.getAttributes().stream().anyMatch(att ->
                att.getPrice().equals(expected.price()) &&
                        att.getStore().equals(expected.store()) &&
                        att.getQuantity().equals(expected.quantity()) &&
                        att.isAvailable() == expected.available()
        );
        assertTrue(exists);
    }
}