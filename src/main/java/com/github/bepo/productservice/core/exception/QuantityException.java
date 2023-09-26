package com.github.bepo.productservice.core.exception;

public class QuantityException extends BadRequestException {
    public QuantityException(String reason) {
        super(reason);
    }
}
