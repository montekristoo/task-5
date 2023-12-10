package com.example.individualwork;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.individualwork.repository")
public class IndividualWorkApplication {
    public static void main(String[] args) {
        SpringApplication.run(IndividualWorkApplication.class, args);
    }
}
