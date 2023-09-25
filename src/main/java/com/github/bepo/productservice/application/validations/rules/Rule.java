package com.github.bepo.productservice.application.validations.rules;

import com.github.bepo.productservice.core.dto.ProductDTO;

import java.util.Objects;

public abstract class Rule {

    private Rule next;

    protected Rule(Rule next) {
        this.next = next;
    }

    public void validDTO(ProductDTO productDTO) {
        validation(productDTO);
        doNext(productDTO);
    }

    protected abstract void validation(ProductDTO productDTO);

    protected void doNext(ProductDTO productDTO) {
        if (Objects.isNull(next)){
            return;
        }
        next.validDTO(productDTO);
    }
}
