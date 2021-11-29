package com.careerdevs.relationship_mapping.controllers;


import com.careerdevs.relationship_mapping.repositories.BreedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/breeds")
public class BreedController {
    @Autowired
    private BreedRepository repository;
}
