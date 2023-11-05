package com.example.individualwork.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class FlightCrew {
    @Id
    @GeneratedValue
    private int crewId;
    private int flightId;
    private String crewMemberName;
    private String role;
}