package com.careerdevs.relationship_mapping.controllers;

import com.careerdevs.relationship_mapping.models.User;
import com.careerdevs.relationship_mapping.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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

    @GetMapping("/{id}")
    public @ResponseBody User getById(@PathVariable long id) {
        return repository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<List<User>> findByEmail(@PathVariable String email) {
        return new ResponseEntity<>(repository.findByEmail(email), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User newUser) {
        return new ResponseEntity<>(repository.save(newUser), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public @ResponseBody User updateUserById(@PathVariable Long id, @RequestBody User updateData) {
        User updatedUser = repository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));

        if(updateData.getName() != null) updatedUser.setName(updateData.getName());
        if(updateData.getEmail() != null) updatedUser.setEmail(updateData.getEmail());

        return repository.save(updatedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> destroyUser(@PathVariable Long id) {
        repository.deleteById(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }

}
