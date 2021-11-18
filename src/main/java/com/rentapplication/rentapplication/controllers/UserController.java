package com.rentapplication.rentapplication.controllers;

import com.rentapplication.rentapplication.entities.User;
import com.rentapplication.rentapplication.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/cachedemo/v1/users")
public class UserController
        {

            @Autowired
            private UserRepository userRepository;


            private BCryptPasswordEncoder bCryptPasswordEncoder;






@PostMapping("/signup")

public void signUp(@RequestBody User user)

        {


        userRepository.save(user);

        }

        }


