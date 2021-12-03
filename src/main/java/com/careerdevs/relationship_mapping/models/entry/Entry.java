package com.careerdevs.relationship_mapping.models.entry;

import com.careerdevs.relationship_mapping.models.activity.Activity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
public class Entry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Timestamp timeOfEntry = new Timestamp(System.currentTimeMillis());

    @ManyToMany
    private List<Activity> activity;

    public Entry() {}

    public Entry(Timestamp timeOfEntry, List<Activity> activity) {
        this.timeOfEntry = timeOfEntry;
        this.activity = activity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getTimeOfEntry() {
        return timeOfEntry;
    }

    public void setTimeOfEntry(Timestamp timeOfEntry) {
        this.timeOfEntry = timeOfEntry;
    }

    public List<Activity> getActivity() {
        return activity;
    }

    public void setActivity(List<Activity> activity) {
        this.activity = activity;
    }
}
