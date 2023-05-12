package com.mario.auth.exeption;

import org.springframework.http.HttpStatus;

public final class EmailDuplicateException extends AuthException {
    private static final HttpStatus STATUS = HttpStatus.BAD_REQUEST;
    private static final String MESSAGE = "이미 사용중인 이메일입니다.";

    public EmailDuplicateException() {
        super(STATUS, MESSAGE);
    }
}
