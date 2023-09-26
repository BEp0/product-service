package com.github.bepo.productservice.application.validations;

import com.github.bepo.productservice.application.validations.rules.*;
import com.github.bepo.productservice.core.dto.ProductDTO;

public class ProductValidation {

    public static void fullValidationDTO(ProductDTO productDTO) {
        getFullValidation().validDTO(productDTO);
    }

    private static Rule getFullValidation() {
        return new SkuRule(
                new PriceRule(
                        new StoreRule(
                                new QuantityRule(null))));
    }
}
