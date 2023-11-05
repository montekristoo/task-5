package com.example.individualwork;

import com.example.individualwork.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@EnableScheduling
@SpringBootApplication
@RequiredArgsConstructor
@EnableJpaRepositories(basePackages = "com.example.individualwork.repository")
public class IndividualWorkApplication {
    private final FlightService flightService;
    private final AirCraftService airCraftService;
    private final FlightCrewService flightCrewService;
    private final CancellationReasonService cancellationReasonService;
    private final FlightCancellationReasonService flightCancellationReasonService;

    public static void main(String[] args) {
        SpringApplication.run(IndividualWorkApplication.class, args);
    }

    @Scheduled(fixedDelayString = "PT1H")
    public void run() {
        System.out.println(flightService.findAll());
        System.out.println(airCraftService.findAll());
        System.out.println(flightCrewService.findAll());
        System.out.println(cancellationReasonService.findAll());
        System.out.println(flightCancellationReasonService.findAll());
    }
}
