package com.github.bepo.productservice.application.exception;

public class StoreException extends BadRequestException {
    public StoreException(String reason) {
        super(reason);
    }
}
