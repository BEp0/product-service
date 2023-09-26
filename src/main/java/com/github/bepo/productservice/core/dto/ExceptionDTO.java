package com.github.bepo.productservice.core.dto;

import org.springframework.http.HttpStatus;

public record ExceptionDTO(HttpStatus status, String message) {
}
