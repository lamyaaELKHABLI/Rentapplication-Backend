package com.rentapplication.rentapplication.controllers;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


import com.rentapplication.rentapplication.entities.*;
import com.rentapplication.rentapplication.repositories.CityRepository;
import com.rentapplication.rentapplication.repositories.FunctionalityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rentapplication.rentapplication.payload.request.LoginRequest;
import com.rentapplication.rentapplication.payload.request.SignupRequest;
import com.rentapplication.rentapplication.payload.response.JwtResponse;
import com.rentapplication.rentapplication.payload.response.MessageResponse;
import com.rentapplication.rentapplication.repositories.RoleRepository;
import com.rentapplication.rentapplication.repositories.UserRepository;
import com.rentapplication.rentapplication.security.jwt.JwtUtils;
import com.rentapplication.rentapplication.security.services.UserDetailsImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    CityRepository cityRepository;

    @Autowired
    FunctionalityRepository functionalityRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getFirstname(),
                userDetails.getLastname(),
                userDetails.getEmail(),
                userDetails.getAddress(),
                userDetails.getImage(),
                userDetails.getPhone(),
                userDetails.getBirthdate(),
                userDetails.getCreatedAt(),
                userDetails.getCity(),
                userDetails.getFunctionality(),
                roles));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignupRequest signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

        if (userRepository.existsByUserEmail(signUpRequest.getUserEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }

       Date sqlDate = new java.sql.Date(Calendar.getInstance().getTimeInMillis());
        // Create new user's account
        User user = new User(signUpRequest.getUsername(),
                signUpRequest.getUserFirstname(),
                signUpRequest.getUserLastname(),
                signUpRequest.getUserEmail(),
                encoder.encode(signUpRequest.getUserPassword()),
                signUpRequest.getUserAddress(),
                signUpRequest.getUserImage(),
                signUpRequest.getUserPhone(),

                signUpRequest.getUserBirthdate(),
                sqlDate
                );

        Set<Role> roles = new HashSet<>();
        Role userRole = roleRepository.findByRoleTitle("ROLE_USER");
        roles.add(userRole);

        City userCity = cityRepository.findByCityTitle(signUpRequest.getUserCity());

        Functionality userFunctionality = functionalityRepository.findByFunctionalityTitle(signUpRequest.getUserFunctionality());


        user.setRoles(roles);
        user.setCity(userCity);
        user.setFunctionality(userFunctionality);
        userRepository.save(user);

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }
}