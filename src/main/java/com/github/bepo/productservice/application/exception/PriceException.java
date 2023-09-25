package com.github.bepo.productservice.application.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class PriceException extends ResponseStatusException {
    public PriceException(String reason) {
        super(HttpStatus.BAD_REQUEST, reason);
    }
}
