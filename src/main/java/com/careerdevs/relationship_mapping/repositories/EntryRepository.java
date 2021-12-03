package com.careerdevs.relationship_mapping.repositories;

import com.careerdevs.relationship_mapping.models.entry.Entry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntryRepository extends JpaRepository<Entry, Long> {
}
