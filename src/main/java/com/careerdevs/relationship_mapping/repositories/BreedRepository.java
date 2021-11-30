package com.careerdevs.relationship_mapping.repositories;

import com.careerdevs.relationship_mapping.models.breed.Breed;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BreedRepository extends JpaRepository<Breed, Long> {
}
