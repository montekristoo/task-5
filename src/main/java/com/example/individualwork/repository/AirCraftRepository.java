package com.example.individualwork.repository;

import com.example.individualwork.model.raw.AirCraft;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirCraftRepository extends JpaRepository<AirCraft, Long> {

}