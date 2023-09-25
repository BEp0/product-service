package com.github.bepo.productservice.application.validations.rules;

import com.github.bepo.productservice.core.dto.ProductDTO;
import lombok.AllArgsConstructor;

import java.util.Objects;

public abstract class Rule {

    private Rule next;

    protected Rule(Rule next) {
        this.next = next;
    }

    public abstract void valid(ProductDTO productDTO);

    protected void doNext(ProductDTO productDTO) {
        if (Objects.isNull(next)){
            return;
        }
        next.valid(productDTO);
    }
}
