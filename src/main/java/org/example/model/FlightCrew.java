package org.example.model;

import lombok.Data;

@Data
public class FlightCrew {
    private int crewId;
    private int flightId;
    private String crewMemberName;
    private String role;
}