package com.rentapplication.rentapplication.controllers;


import com.rentapplication.rentapplication.repositories.CityRepository;
import com.rentapplication.rentapplication.repositories.FunctionalityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class FunctionalityController {

    @Autowired
    FunctionalityRepository functionalityRepository;

    @GetMapping("/getFun")
    public ResponseEntity<?> getFun() {

        List<String> cities = functionalityRepository.findAll().stream()
                .map(item -> item.getFunctionalityTitle())
                .collect(Collectors.toList());
        return ResponseEntity.ok(cities);

    }
}