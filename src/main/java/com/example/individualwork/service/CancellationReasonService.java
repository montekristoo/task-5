package com.example.individualwork.service;

import com.example.individualwork.model.CancellationReason;
import com.example.individualwork.repository.CancellationReasonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CancellationReasonService {
    private final CancellationReasonRepository cancellationReasonRepository;

    public List<CancellationReason> findAll() {
        return cancellationReasonRepository.findAll();
    }
}