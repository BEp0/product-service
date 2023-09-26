package com.github.bepo.productservice.application.exception;

public class SkuException extends BadRequestException {
    public SkuException(String reason) {
        super(reason);
    }
}
