package com.careerdevs.relationship_mapping.repositories;

import com.careerdevs.relationship_mapping.models.dog.Dog;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DogRepository extends JpaRepository<Dog, Long> {

    List<Dog> findAllByDogBreed_id(Long id, Sort sort);
}
