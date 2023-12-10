package com.example.individualwork.repository;

import com.example.individualwork.model.raw.CancellationReason;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CancellationReasonRepository extends JpaRepository<CancellationReason, Long> {
}