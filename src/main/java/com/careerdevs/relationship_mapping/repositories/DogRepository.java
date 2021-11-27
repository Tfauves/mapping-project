package com.careerdevs.relationship_mapping.repositories;

import com.careerdevs.relationship_mapping.models.Dog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DogRepository extends JpaRepository<Dog, Long> {
}
