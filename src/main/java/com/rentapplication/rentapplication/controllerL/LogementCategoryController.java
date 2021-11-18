package com.rentapplication.rentapplication.controllerL;

import com.rentapplication.rentapplication.entities.LogementCategory;
import com.rentapplication.rentapplication.repositoryL.LogementCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class LogementCategoryController {
    @Autowired(required = true)
    private LogementCategoryRepository logementcategoryrepository;

    @CrossOrigin("http://localhost:4200")
    @GetMapping("/logementcategories")
    public List<LogementCategory> getAllLogementcategories(){
        return logementcategoryrepository.findAll();
    }

}
