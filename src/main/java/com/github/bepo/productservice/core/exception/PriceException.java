package com.github.bepo.productservice.core.exception;

public class PriceException extends BadRequestException {
    public PriceException(String reason) {
        super(reason);
    }
}
