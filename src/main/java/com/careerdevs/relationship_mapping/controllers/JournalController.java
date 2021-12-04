package com.careerdevs.relationship_mapping.controllers;

import com.careerdevs.relationship_mapping.models.journal.Journal;
import com.careerdevs.relationship_mapping.repositories.JournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@CrossOrigin
@RestController
@RequestMapping("/api/journal")
public class JournalController {

    @Autowired
    private JournalRepository repository;

    @GetMapping("/{journalId}")
    public @ResponseBody Journal getJournalById(@PathVariable Long journalId) {
        return repository.findById(journalId).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Journal> createJournal(@RequestBody Journal newJournal) {
        return new ResponseEntity<>(repository.save(newJournal), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> destroyJournal(@PathVariable Long id) {
        repository.deleteById(id);
        return new ResponseEntity<>("Delete", HttpStatus.OK);
    }
}
