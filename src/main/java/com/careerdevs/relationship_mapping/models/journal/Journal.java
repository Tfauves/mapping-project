package com.careerdevs.relationship_mapping.models.journal;

import com.careerdevs.relationship_mapping.models.entry.Entry;
import com.careerdevs.relationship_mapping.models.owner.Owner;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;

import javax.persistence.*;
import java.util.List;

@Entity
public class Journal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    private List<Entry> entry;

    @OneToOne
    @JsonIncludeProperties("id")
    private Owner owner;

    public Journal() {}

    public Journal(Owner owner, List<Entry> entry) {
        this.owner = owner;
        this.entry = entry;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Entry> getEntry() {
        return entry;
    }

    public void setEntry(List<Entry> entry) {
        this.entry = entry;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
