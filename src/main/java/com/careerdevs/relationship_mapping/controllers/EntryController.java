package com.careerdevs.relationship_mapping.controllers;


import com.careerdevs.relationship_mapping.models.entry.Entry;
import com.careerdevs.relationship_mapping.models.owner.Owner;
import com.careerdevs.relationship_mapping.repositories.EntryRepository;
import com.careerdevs.relationship_mapping.repositories.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/api/entries")
public class EntryController {
    @Autowired
    private EntryRepository repository;

    @GetMapping
    public @ResponseBody List<Entry> getAllEntries() {
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<Entry> createEntry(@RequestBody Entry newEntry) {
        return new ResponseEntity<>(repository.save(newEntry), HttpStatus.CREATED);
    }

}
