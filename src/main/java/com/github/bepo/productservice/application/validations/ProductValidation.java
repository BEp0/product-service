package com.github.bepo.productservice.application.validations;

import com.github.bepo.productservice.application.validations.rules.*;
import com.github.bepo.productservice.core.dto.ProductDTO;
import org.springframework.stereotype.Component;

@Component
public class ProductValidation {

    public void fullValidationDTO(ProductDTO productDTO) {
        getFullValidation().validDTO(productDTO);
    }

    private Rule getFullValidation() {
        return new SkuRule(
                new PriceRule(
                        new StoreRule(
                                new QuantityRule(null))));
    }
}
