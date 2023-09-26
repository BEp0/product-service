package com.github.bepo.productservice.application.exception;

public class PriceException extends BadRequestException {
    public PriceException(String reason) {
        super(reason);
    }
}
