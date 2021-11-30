package com.careerdevs.relationship_mapping.controllers;

import com.careerdevs.relationship_mapping.models.Dog;
import com.careerdevs.relationship_mapping.repositories.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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

    @GetMapping("/breed/{breedId}")
    public List<Dog> getByBreed(@PathVariable Long breedId) {
        return repository.findAllByDogBreed_id(breedId, Sort.by("name"));
    }

    @PostMapping
    public ResponseEntity<Dog> createDog(@RequestBody Dog newDog) {
        return new ResponseEntity<>(repository.save(newDog), HttpStatus.CREATED);
    }

    @PutMapping("/breed")
    public Dog addBreed(@RequestBody Dog updateData) {
        Dog dog = repository.findById(updateData.getId()).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
        dog.getDogBreed().addAll(updateData.getDogBreed());
        return repository.save(dog);
    }

    @PutMapping("/{id}")
    public @ResponseBody Dog updateDogById(@PathVariable Long id, @RequestBody Dog updateData) {
        Dog updatedDog = repository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));

        if (updateData.getName() != null) updatedDog.setName(updateData.getName());
        if (updateData.getAge() != null) updatedDog.setAge(updateData.getAge());
        if ( updateData.getWeight() != null) updatedDog.setWeight(updateData.getWeight());
        if (updateData.getDogBreed() != null) updatedDog.setDogBreed(updateData.getDogBreed());

        return repository.save(updatedDog);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> destroyDog(@PathVariable Long id) {
        repository.deleteById(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }

}
