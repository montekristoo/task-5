package com.example.individualwork.service;

import com.example.individualwork.model.raw.AirCraft;
import com.example.individualwork.model.dto.AirCraftDTO;
import com.example.individualwork.repository.AirCraftRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AirCraftService {
    private final AirCraftRepository airCraftRepository;

    public List<AirCraft> findAll() {
        return airCraftRepository.findAll();
    }

    public void save(AirCraftDTO airCraft) {
        AirCraft toAirCraft = airCraft.toAirCraft();
        airCraftRepository.save(toAirCraft);
    }
}