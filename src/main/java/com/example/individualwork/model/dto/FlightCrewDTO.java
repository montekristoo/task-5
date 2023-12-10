package com.example.individualwork.model.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class FlightCrewDTO {
    private int crewId;
    private int flightId;
    private String crewMemberName;
    private String role;
}