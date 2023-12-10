package com.example.individualwork.model.dto;

import com.example.individualwork.model.raw.AirCraft;
import lombok.Data;

import java.util.Objects;

@Data
public class AirCraftDTO {
    private int aircraftId;
    private String aircraftName;
    private int capacity;
    private int rangeKm;

    public AirCraft toAirCraft() {
        AirCraft airCraft = new AirCraft();
        airCraft.setAircraftId(aircraftId);
        airCraft.setAircraftName(aircraftName);
        airCraft.setCapacity(capacity);
        airCraft.setRangeKm(rangeKm);
        return airCraft;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AirCraftDTO airCraft = (AirCraftDTO) o;
        return capacity == airCraft.capacity && rangeKm == airCraft.rangeKm && Objects.equals(aircraftName, airCraft.aircraftName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(aircraftName, capacity, rangeKm);
    }
}