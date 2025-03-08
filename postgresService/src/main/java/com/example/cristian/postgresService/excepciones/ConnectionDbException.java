package com.example.cristian.postgresService.excepciones;

/**
 * Excepcion personalizada de fallo de conexion a postgresSQL
 * @author cristian
 * @version 1.0
 */
public class ConnectionDbException extends RuntimeException {
    public ConnectionDbException(String message) {
        super(message);
    }
}
