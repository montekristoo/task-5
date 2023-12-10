package com.example.individualwork.model.raw;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class FlightCancellation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cancellationId;
    private int flightId;
    private int reasonId;
    private Date cancellationTime;
}