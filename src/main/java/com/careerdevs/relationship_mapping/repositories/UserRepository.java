package com.careerdevs.relationship_mapping.repositories;

import com.careerdevs.relationship_mapping.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User>findByEmail(String email);

}
