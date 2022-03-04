package com.careerdevs.expressian.controllers;


import com.careerdevs.expressian.entities.auth.ERole;
import com.careerdevs.expressian.entities.auth.Role;
import com.careerdevs.expressian.entities.auth.User;
import com.careerdevs.expressian.repositories.RoleRepository;
import com.careerdevs.expressian.repositories.UserRepository;
import com.careerdevs.expressian.security.jwt.JwtUtils;
import com.careerdevs.expressian.security.services.UserDetailsImpl;
import com.careerdevs.expressian.services.DataBaseService;
import com.careerdevs.expressian.payloads.request.LoginRequest;
import com.careerdevs.expressian.payloads.request.SignupRequest;
import com.careerdevs.expressian.payloads.response.JwtResponse;
import com.careerdevs.expressian.payloads.response.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private JwtUtils jwtUtils;

   @Autowired
    private DataBaseService dataBaseService;

    @GetMapping
    public List<User> getAllUsers(){return userRepository.findAll();}

    @PostMapping("/signin")
    public ResponseEntity<JwtResponse> authenticateUser(@RequestBody LoginRequest loginRequest) {
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
                                                 roles));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignupRequest signupRequest) {
        if (userRepository.existsByUsername(signupRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email already in use please login or reset password"));
        }

        // create new account
        User user = new User(signupRequest.getUsername(), encoder.encode(signupRequest.getPassword()));
        Set<String> strRoles = signupRequest.getRoles();
        Set<Role> roles = new HashSet<>();

       if(!dataBaseService.rolesExists()){
           dataBaseService.writeRoles();
       }


        if (strRoles == null) {
            Role customerRole = roleRepository.findByName(ERole.CUSTOMER).orElseThrow(() -> new RuntimeException("Error: Customer Role is not found"));
            roles.add(customerRole);
        } else {
            strRoles.forEach(role -> {
                switch(role) {
                    case "admin":
                    case "administrator":
                        Role adminRole = roleRepository.findByName(ERole.ADMIN).orElseThrow(() -> new RuntimeException("Error:Admin Role is not found"));
                        roles.add(adminRole);
                        break;
                    case "employ":
                    case "employee":
                        Role employeeRole = roleRepository.findByName(ERole.EMPLOYEE).orElseThrow(() -> new RuntimeException("Error: Employee Role is not found"));
                        roles.add(employeeRole);
                        break;
                    default:
                        Role customerRole = roleRepository.findByName(ERole.CUSTOMER).orElseThrow(() -> new RuntimeException("Error: Customer Role is not found"));
                        roles.add(customerRole);
                        break;
                }
            });
        }

        user.setRoles(roles);
        userRepository.save(user);

        return new ResponseEntity(new MessageResponse("User registered successfully"), HttpStatus.CREATED);
    }

}
