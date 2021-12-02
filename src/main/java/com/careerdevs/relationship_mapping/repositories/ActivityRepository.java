package com.careerdevs.relationship_mapping.repositories;

import com.careerdevs.relationship_mapping.models.activity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
}
