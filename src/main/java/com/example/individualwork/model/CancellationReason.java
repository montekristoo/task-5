package com.example.individualwork.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class CancellationReason {
    @Id
    @GeneratedValue
    private int reasonId;
    private String reasonText;
}