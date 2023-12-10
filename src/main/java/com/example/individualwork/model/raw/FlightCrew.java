package com.example.individualwork.model.raw;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class FlightCrew {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int crewId;
    private int flightId;
    private String crewMemberName;
    private String role;
}