package com.careerdevs.relationship_mapping.controllers;

import com.careerdevs.relationship_mapping.repositories.JournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api/journal")
public class JournalController {

    @Autowired
    private JournalRepository repository;

    @GetMapping()
}
