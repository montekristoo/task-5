package org.example.exception;

/**
 * @author Cebotari Viktor
 */
public class DatabaseConnectionException extends RuntimeException {
    public DatabaseConnectionException(String message) {
        super(message);
    }
}