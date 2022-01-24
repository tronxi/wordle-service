package com.example.wordleservice.domain.exception;

public class InvalidFormatException extends DomainException {
    public InvalidFormatException() {
        super("Invalid format");
    }
}
