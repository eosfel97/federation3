package com.greta.federation.exception;

import java.util.List;

public class InvalidUserException extends RuntimeException {
    private final List<String> errors;

    public InvalidUserException(List<String> errors) {
        super("Invalid user data");
        this.errors = errors;
    }

    public List<String> getErrors() {
        return errors;
    }
}
