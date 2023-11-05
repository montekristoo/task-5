package com.example.individualwork.service;

import com.example.individualwork.model.FlightCancellation;
import com.example.individualwork.repository.FlightCancellationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FlightCancellationReasonService {
    private final FlightCancellationRepository flightCancellationRepository;

    public List<FlightCancellation> findAll() {
        return flightCancellationRepository.findAll();
    }
}