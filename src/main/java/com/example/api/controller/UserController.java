package com.example.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users") // Main endpoint
public class UserController {

    // GET /api/v1/users - Fetch all users
    @GetMapping
    public ResponseEntity<String> getAllUsers() {
        return ResponseEntity.ok("List of Users");
    }

}