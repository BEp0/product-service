package com.github.bepo.productservice.application.validations.rules;

import com.github.bepo.productservice.application.exception.StoreException;
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
