package org.example.config;

import org.example.exception.DatabaseConnectionException;
import org.example.model.Database;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory implements AutoCloseable {
    private static Connection connection;

    public static Connection getConnection(Database database) {
        try {
            connection = DriverManager.getConnection(database.getJdbcUrl(), database.getUsername(), database.getPassword());
            return connection;
        } catch (Exception e) {
            String message = String.format("Error connecting to database %s, error: %s", database.getJdbcUrl(), e.getMessage());
            throw new DatabaseConnectionException(message);
        }
    }

    @Override
    public void close() throws Exception {
        if (connection != null) connection.close();
    }
}