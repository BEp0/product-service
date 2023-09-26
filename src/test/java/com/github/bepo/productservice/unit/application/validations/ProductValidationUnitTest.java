package com.github.bepo.productservice.unit.application.validations;

import com.github.bepo.productservice.application.validations.ProductValidation;
import com.github.bepo.productservice.core.dto.ProductDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class ProductValidationUnitTest {

    private final static String SKU = "00000001";
    private final static BigDecimal PRICE = new BigDecimal(11);
    private final static Long STORE = 1L;
    private final static Long QUANTITY = 190L;
    private final static boolean AVAILABLE = true;

    @InjectMocks
    private ProductValidation validation;

    @Test
    @DisplayName("Pass by all validations")
    void allValidations() {
        validation.fullValidationDTO(new ProductDTO(SKU, PRICE, STORE, QUANTITY, AVAILABLE));
    }

    @Test
    @DisplayName("Don't pass by sku null")
    void skuNullValidations() {
        var skuNullMessageExpected = "Sku cannot be null";
        var skuNull = Assertions.assertThrows(ResponseStatusException.class, () ->
            validation.fullValidationDTO(new ProductDTO(null, PRICE, STORE, QUANTITY, AVAILABLE)));
        assertTrue(skuNull.getMessage().contains(skuNullMessageExpected));
    }

    @Test
    @DisplayName("Don't pass by sku null")
    void skuBlankValidations() {
        var skuBlankMessageExpected = "Sku cannot be blank";
        var skuBlank = Assertions.assertThrows(ResponseStatusException.class, () ->
                validation.fullValidationDTO(new ProductDTO("", PRICE, STORE, QUANTITY, AVAILABLE)));
        assertTrue(skuBlank.getMessage().contains(skuBlankMessageExpected));
    }

    @Test
    @DisplayName("Don't pass by sku null")
    void skuWithLettersValidations() {
        var skuWithLettersMessageExpected = "Sku should have only numbers";
        var skuWithLetters = Assertions.assertThrows(ResponseStatusException.class, () ->
                validation.fullValidationDTO(new ProductDTO("SKU0909", PRICE, STORE, QUANTITY, AVAILABLE)));
        assertTrue(skuWithLetters.getMessage().contains(skuWithLettersMessageExpected));
    }

    @Test
    @DisplayName("Don't pass by sku lower than 5")
    void skuLowerValidations() {
        var skuLowerMessageExpected = "Sku length cannot be lower than 5";
        var skuLowerThanMinSize = Assertions.assertThrows(ResponseStatusException.class, () ->
                validation.fullValidationDTO(new ProductDTO("000", PRICE, STORE, QUANTITY, AVAILABLE)));
        assertTrue(skuLowerThanMinSize.getMessage().contains(skuLowerMessageExpected));
    }
}