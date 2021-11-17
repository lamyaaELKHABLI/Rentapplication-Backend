package com.rentapplication.rentapplication.controllerL;

import com.rentapplication.rentapplication.entities.City;
import com.rentapplication.rentapplication.repositoryL.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class CityController {

    @Autowired(required = true)
    private CityRepository cityrepository;

    @CrossOrigin("http://localhost:4200")
    @GetMapping("/cities")
    public List<City> getAllcities(){
        return cityrepository.findAll();
    }
}
