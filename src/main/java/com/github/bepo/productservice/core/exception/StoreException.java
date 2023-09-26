package com.github.bepo.productservice.core.exception;

public class StoreException extends BadRequestException {
    public StoreException(String reason) {
        super(reason);
    }
}
