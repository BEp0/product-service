package com.github.bepo.productservice.application.validations.rules;

import com.github.bepo.productservice.application.exception.SkuException;
import com.github.bepo.productservice.core.dto.ProductDTO;

import static java.util.Objects.isNull;

public class SkuRule extends Rule {

    public static final int MIN_LENGTH_SKU = 5;
    public static final String REGEX_ONLY_NUMBERS = "[0-9]+";

    public SkuRule(Rule next) {
        super(next);
    }

    @Override
    protected void validation(ProductDTO productDTO) {
        var sku = productDTO.sku();

        if (isNull(sku))
            throw new SkuException("Sku cannot be null");

        if (sku.isBlank())
            throw new SkuException("Sku cannot be blank");

        if (!sku.matches(REGEX_ONLY_NUMBERS))
            throw new SkuException("Sku should have only numbers");

        if (sku.length() < MIN_LENGTH_SKU)
            throw new SkuException("Sku length cannot be lower than " + MIN_LENGTH_SKU);
    }
}
