package com.example.individualwork.model.raw;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "aircraft")
public class AirCraft {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int aircraftId;
    private String aircraftName;
    private int capacity;
    private int rangeKm;
}