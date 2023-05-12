package com.mario.auth.exeption;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
class AuthException extends RuntimeException {
    private final HttpStatus status;

    AuthException(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }

    public ErrorResponse getErrorResponse() {
        return new ErrorResponse(this.status.value(), this.getMessage());
    }
}
