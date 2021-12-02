package com.careerdevs.relationship_mapping.controllers;

import com.careerdevs.relationship_mapping.models.activityType.ActivityType;
import com.careerdevs.relationship_mapping.repositories.ActivityTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

}
