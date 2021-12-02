package com.careerdevs.relationship_mapping.repositories;

import com.careerdevs.relationship_mapping.models.owner.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
    List<Owner>findByEmail(String email);

}
