package com.example.cristian.postgresService.excepciones;

/**
 * Clase con excepcion de ids
 * @author cristian
 * @version 1.0
 */
public class IdException extends RuntimeException {
    public IdException(String message) {
        super(message);
    }
}
