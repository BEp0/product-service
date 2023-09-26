package com.github.bepo.productservice.core.useCase.product.validation.rules;

import com.github.bepo.productservice.core.exception.StoreException;
import com.github.bepo.productservice.core.dto.ProductDTO;

import static java.util.Objects.isNull;

public class StoreRule extends Rule {

    public StoreRule(Rule next) {
        super(next);
    }

    @Override
    public void validation(ProductDTO productDTO) {
        var store = productDTO.store();

        if (isNull(store))
            throw new StoreException("Store cannot be null");
    }
}
