package com.github.bepo.productservice.application.exception;

public class QuantityException extends BadRequestException {
    public QuantityException(String reason) {
        super(reason);
    }
}
