package com.github.bepo.productservice.core.useCase.product.validation.rules;

import com.github.bepo.productservice.core.exception.PriceException;
import com.github.bepo.productservice.core.dto.ProductDTO;

import java.math.BigDecimal;

import static java.util.Objects.isNull;

public class PriceRule extends Rule {

    public PriceRule(Rule next) {
        super(next);
    }

    @Override
    public void validation(ProductDTO productDTO) {
        var price = productDTO.price();

        if (isNull(price))
            throw new PriceException("Price cannot be null");

        if (price.compareTo(BigDecimal.ZERO) < 0)
            throw new PriceException("Price cannot be lower than zero");
    }
}
