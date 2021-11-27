package com.careerdevs.relationship_mapping.controllers;

import com.careerdevs.relationship_mapping.models.User;
import com.careerdevs.relationship_mapping.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserRepository repository;

    @GetMapping
    public @ResponseBody List<User> findAll() {
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User newUser) {
        return new ResponseEntity<>(repository.save(newUser), HttpStatus.CREATED);
    }
}
