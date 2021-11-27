package com.careerdevs.relationship_mapping.repositories;

import com.careerdevs.relationship_mapping.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
