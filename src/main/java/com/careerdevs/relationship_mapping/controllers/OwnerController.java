package com.careerdevs.relationship_mapping.controllers;

import com.careerdevs.relationship_mapping.models.owner.Owner;
import com.careerdevs.relationship_mapping.repositories.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/owners")
public class OwnerController {
    @Autowired
    private OwnerRepository repository;

    @GetMapping
    public @ResponseBody List<Owner> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody
    Owner getById(@PathVariable long id) {
        return repository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<List<Owner>> findByEmail(@PathVariable String email) {
        return new ResponseEntity<>(repository.findByEmail(email), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Owner> createUser(@RequestBody Owner newUser) {
        return new ResponseEntity<>(repository.save(newUser), HttpStatus.CREATED);
    }

    @PutMapping("/dog")
    public Owner addDogToOwner(@RequestBody Owner updateData) {
        Owner owner = repository.findById(updateData.getId()).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
        owner.getDog().addAll(updateData.getDog());
        return repository.save(owner);
    }

    @PutMapping("/{id}")
    public @ResponseBody
    Owner updateOwnerById(@PathVariable Long id, @RequestBody Owner updateData) {
        Owner owner = repository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));

        if (updateData.getName() != null) owner.setName(updateData.getName());
        if (updateData.getEmail() != null) owner.setEmail(updateData.getEmail());
        if (updateData.getDog() != null) owner.setDog(updateData.getDog());
        if (updateData.getJournal() != null) owner.setJournal(updateData.getJournal());

        return repository.save(owner);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> destroyOwner(@PathVariable Long id) {
        repository.deleteById(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }

}
