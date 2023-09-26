package com.github.bepo.productservice.application.validations.rules;

import com.github.bepo.productservice.core.dto.ProductDTO;

import static java.util.Objects.isNull;

public abstract class Rule {

    private final Rule next;

    protected Rule(Rule next) {
        this.next = next;
    }

    public void validDTO(ProductDTO productDTO) {
        validation(productDTO);
        doNext(productDTO);
    }

    protected abstract void validation(ProductDTO productDTO);

    protected void doNext(ProductDTO productDTO) {
        if (isNull(next))
            return;
        next.validDTO(productDTO);
    }
}
