package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Database {
    private String jdbcUrl;
    private String username;
    private String password;
    private String driverClassName;
}