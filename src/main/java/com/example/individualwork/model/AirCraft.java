package com.example.individualwork.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "aircraft")
public class AirCraft {
    @Id
    @GeneratedValue
    private int aircraftId;
    private String aircraftName;
    private int capacity;
    private int rangeKm;
}