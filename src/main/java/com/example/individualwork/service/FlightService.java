package com.example.individualwork.service;

import com.example.individualwork.model.Flight;
import com.example.individualwork.repository.FlightRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FlightService {
    private final FlightRepository flightRepository;

    public List<Flight> findAll() {
        return flightRepository.findAll();
    }
}