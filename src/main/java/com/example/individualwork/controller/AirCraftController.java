package com.example.individualwork.controller;

import com.example.individualwork.model.dto.AirCraftDTO;
import com.example.individualwork.service.AirCraftService;
import com.example.individualwork.util.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/aircraft")
public class AirCraftController {
    private final AirCraftService airCraftService;

    @GetMapping("/register")
    public String showForm(Model model) {
        return Constants.ADD_AIRCRAFT;
    }

    @PostMapping("/save")
    public String save(AirCraftDTO airCraft) {
        airCraftService.save(airCraft);
        return Constants.REDIRECT;
    }
}