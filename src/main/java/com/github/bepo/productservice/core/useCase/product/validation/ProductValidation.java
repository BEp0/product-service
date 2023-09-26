package com.github.bepo.productservice.core.useCase.product.validation;

import com.github.bepo.productservice.core.dto.ProductDTO;
import com.github.bepo.productservice.core.useCase.product.validation.rules.PriceRule;
import com.github.bepo.productservice.core.useCase.product.validation.rules.QuantityRule;
import com.github.bepo.productservice.core.useCase.product.validation.rules.Rule;
import com.github.bepo.productservice.core.useCase.product.validation.rules.SkuRule;
import com.github.bepo.productservice.core.useCase.product.validation.rules.StoreRule;

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
