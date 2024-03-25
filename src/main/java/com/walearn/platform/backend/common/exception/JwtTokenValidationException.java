package com.walearn.platform.backend.common.exception;

public class JwtTokenValidationException extends RuntimeException {

    public JwtTokenValidationException(String message) {
        super(message);
    }
}