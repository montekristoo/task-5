package com.example.individualwork.model.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Data
public class FlightCancellationDTO {
    private int cancellationId;
    private int flightId;
    private int reasonId;
    private Date cancellationTime;
}