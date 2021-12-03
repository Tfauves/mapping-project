package com.careerdevs.relationship_mapping.controllers;

import com.careerdevs.relationship_mapping.models.activity.Activity;
import com.careerdevs.relationship_mapping.repositories.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/actives")
public class ActivityController {
    @Autowired
    private ActivityRepository repository;

    @GetMapping
    public @ResponseBody List<Activity> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<Activity> createActivity(@RequestBody Activity newActivity) {
        return new ResponseEntity<>(repository.save(newActivity), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public @ResponseBody Activity updateActivity(@PathVariable Long id, @RequestBody Activity updateData) {
        Activity activity = repository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));

        if (updateData.getDuration() != null) activity.setDuration(updateData.getDuration());
        if (updateData.getActivityType() != null) activity.setActivityType(updateData.getActivityType());

        return repository.save(activity);

    }

}
