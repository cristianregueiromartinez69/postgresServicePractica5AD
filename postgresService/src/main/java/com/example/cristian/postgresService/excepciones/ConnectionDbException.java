package com.example.cristian.postgresService.excepciones;

public class ConnectionDbException extends RuntimeException {
    public ConnectionDbException(String message) {
        super(message);
    }
}
