package com.github.bepo.productservice.application.validations.rules;

import com.github.bepo.productservice.application.exception.PriceException;
import com.github.bepo.productservice.core.dto.ProductDTO;

import java.math.BigDecimal;
import java.util.Objects;

public class PriceRule extends Rule {

    public PriceRule(Rule next) {
        super(next);
    }

    @Override
    public void validation(ProductDTO productDTO) {
        var price = productDTO.price();

        if (Objects.isNull(price))
            throw new PriceException("Price cannot be null");

        if (price.compareTo(BigDecimal.ZERO) < 0)
            throw new PriceException("Price cannot be lower than zero");
    }
}
