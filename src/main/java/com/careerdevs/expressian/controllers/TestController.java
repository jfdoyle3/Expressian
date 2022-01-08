package com.careerdevs.expressian.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/test")
public class TestController {

    @GetMapping("/public")
    public String allAccess() {
        return "public content";
    }

    @GetMapping("/customer")
//    @PreAuthorize("hasRole('CUSTOMER') or hasRole('EMPLOYEE') or hasRole('ADMIN')")
    @PreAuthorize("hasRole('CUSTOMER')")
    public String userAccess() {
        return "Customer content";
    }

    @GetMapping("/employee")
    @PreAuthorize("hasRole('EMPLOYEE') or hasRole('ADMIN')")
    public String modAccess() {
        return "Employee content";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess() {
        return "admin content";
    }
}

