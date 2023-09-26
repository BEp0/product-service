package com.github.bepo.productservice.core.useCase.product.validation.rules;

import com.github.bepo.productservice.core.exception.QuantityException;
import com.github.bepo.productservice.core.dto.ProductDTO;
import lombok.extern.slf4j.Slf4j;

import static java.util.Objects.isNull;

@Slf4j
public class QuantityRule extends Rule {

    private static final int MIN_QUANTITY = 0;

    public QuantityRule(Rule next) {
        super(next);
    }

    @Override
    public void validation(ProductDTO productDTO) {
        Long quantity = productDTO.quantity();

        if (isNull(quantity))
            throw new QuantityException("Quantity cannot be null");

        if (quantity < MIN_QUANTITY)
            throw new QuantityException("Quantity cannot be lower than " + MIN_QUANTITY);
    }
}
