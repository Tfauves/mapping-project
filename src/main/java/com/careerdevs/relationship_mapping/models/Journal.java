package com.careerdevs.relationship_mapping.models;

import com.careerdevs.relationship_mapping.models.entry.Entry;
import com.careerdevs.relationship_mapping.models.owner.Owner;

import javax.persistence.*;

@Entity
public class Journal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    private Entry entry;

//    @OneToOne
//    private Owner owner;

    public Journal() {}

//    public Journal(Entry entry) {
//        this.entry = entry;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Entry getEntry() {
        return entry;
    }

    public void setEntry(Entry entry) {
        this.entry = entry;
    }
}
