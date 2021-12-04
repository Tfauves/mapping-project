package com.careerdevs.relationship_mapping.repositories;

import com.careerdevs.relationship_mapping.models.journal.Journal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JournalRepository extends JpaRepository<Journal, Long> {
}
