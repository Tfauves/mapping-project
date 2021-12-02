package com.careerdevs.relationship_mapping.controllers;

import com.careerdevs.relationship_mapping.models.activityType.ActivityType;
import com.careerdevs.relationship_mapping.repositories.ActivityTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/types")
public class ActivityTypeController {
    @Autowired
    private ActivityTypeRepository repository;

    @GetMapping
    public @ResponseBody List<ActivityType> getActivityType() {
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<ActivityType> createType(@RequestBody ActivityType newType) {
        return new ResponseEntity<>(repository.save(newType), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public @ResponseBody ActivityType updateType(@PathVariable Long id, @RequestBody ActivityType updateData) {
        ActivityType type = repository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));

        if (updateData.getName() != null) type.setName(updateData.getName());

        return repository.save(type);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> destroyType(@PathVariable Long id) {
        repository.deleteById(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }

}
