package org.example.service;

import lombok.NoArgsConstructor;
import org.example.exception.DatabaseConnectionException;

import java.sql.Connection;
import java.sql.ResultSet;

/**
 * @author Cebotari Viktor
 */
@NoArgsConstructor
public class DatabaseExecutorService {
    private Connection connection;

    public DatabaseExecutorService(Connection connection) {
        this.connection = connection;
    }

    public long executeUpdate(String sql) {
        try {
            var statement = connection.createStatement();
            return statement.executeUpdate(sql);
        } catch (Exception e) {
            throw new DatabaseConnectionException(e.getMessage());
        }
    }

    public ResultSet executeQuery(String sql) {
        try {
            var statement = connection.createStatement();
            return statement.executeQuery(sql);
        } catch (Exception e) {
            throw new DatabaseConnectionException(e.getMessage());
        }
    }
}