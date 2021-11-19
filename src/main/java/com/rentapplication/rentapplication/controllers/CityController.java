package com.rentapplication.rentapplication.controllers;

import com.rentapplication.rentapplication.entities.City;
import com.rentapplication.rentapplication.payload.request.SignupRequest;
import com.rentapplication.rentapplication.payload.response.JwtResponse;
import com.rentapplication.rentapplication.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class CityController {

    @Autowired
    CityRepository cityRepository;

    @GetMapping("/getCities")
    public ResponseEntity<?> getCities() {

        List<String> cities = cityRepository.findAll().stream()
                .map(item -> item.getCityTitle())
                .collect(Collectors.toList());
        return ResponseEntity.ok(cities);

    }
    @CrossOrigin("http://localhost:4200")
    @GetMapping("/cities")
    public List<City> getAllcities(){
        return cityRepository.findAll();
    }
}
