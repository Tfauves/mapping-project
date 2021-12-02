package com.careerdevs.relationship_mapping.repositories;

import com.careerdevs.relationship_mapping.models.activityType.ActivityType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityTypeRepository extends JpaRepository<ActivityType, Long> {
}
