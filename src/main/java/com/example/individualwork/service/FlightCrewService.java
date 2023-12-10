package com.example.individualwork.service;

import com.example.individualwork.model.raw.FlightCrew;
import com.example.individualwork.repository.FlightCrewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FlightCrewService {
    private final FlightCrewRepository flightCrewRepository;

    public List<FlightCrew> findAll() {
        return flightCrewRepository.findAll();
    }
}