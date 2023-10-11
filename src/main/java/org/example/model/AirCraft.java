package org.example.model;

import lombok.Data;

@Data
public class AirCraft {
    private int aircraftId;
    private String aircraftName;
    private int capacity;
    private int rangeKm;
}