package com.careerdevs.relationship_mapping.controllers;


import com.careerdevs.relationship_mapping.models.Breed;
import com.careerdevs.relationship_mapping.repositories.BreedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/breeds")
public class BreedController {
    @Autowired
    private BreedRepository repository;

    @GetMapping
    public @ResponseBody List<Breed> getAllBreeds() {
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<Breed> createBreed(@RequestBody Breed newBreed) {
        return new ResponseEntity<>(repository.save(newBreed), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public @ResponseBody Breed updateById(@PathVariable Long id, @RequestBody Breed updateData) {
        Breed breed = repository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));

        if (updateData.getName() != null) breed.setName(updateData.getName());
        if (updateData.getBreedGroup() != null) breed.setBreedGroup(updateData.getBreedGroup());

        return repository.save(breed);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> destroyBreed(@PathVariable Long id) {
        repository.deleteById(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
}
