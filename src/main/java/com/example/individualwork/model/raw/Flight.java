package com.example.individualwork.model.raw;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int flightId;
    private int aircraftId;
    private String departureAirport;
    private String destinationAirport;
    private Date departureTime;
    private Date arrivalTime;
    private String status;
}