package com.careerdevs.relationship_mapping.controllers;

import com.careerdevs.relationship_mapping.models.Dog;
import com.careerdevs.relationship_mapping.repositories.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/dogs")
public class DogController {

    @Autowired
    private DogRepository repository;

    @GetMapping
    public @ResponseBody List<Dog> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<Dog> createDog(@RequestBody Dog newDog) {
        return new ResponseEntity<>(repository.save(newDog), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public @ResponseBody Dog updateDogById(@PathVariable Long id, @RequestBody Dog updateData) {
        Dog updatedDog = repository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));

        if (updateData.getName() != null) updatedDog.setName(updateData.getName());
        if (updateData.getAge() != null) updatedDog.setAge(updateData.getAge());
        if ( updateData.getWeight() != null) updatedDog.setWeight(updateData.getWeight());

        return repository.save(updatedDog);
    }

}
