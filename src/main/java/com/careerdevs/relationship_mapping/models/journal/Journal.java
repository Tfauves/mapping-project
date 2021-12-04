package com.careerdevs.relationship_mapping.models.journal;

import com.careerdevs.relationship_mapping.models.entry.Entry;
import com.careerdevs.relationship_mapping.models.owner.Owner;

import javax.persistence.*;
import java.util.List;

@Entity
public class Journal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    private List<Entry> entry;

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

    public List<Entry> getEntry() {
        return entry;
    }

    public void setEntry(List<Entry> entry) {
        this.entry = entry;
    }
}
