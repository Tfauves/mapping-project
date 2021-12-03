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
    private Timestamp timeOfEntry;

    @ManyToMany
    private List<Activity> activityList;

    public Entry() {}

    public Entry(Timestamp timeOfEntry, List<Activity> activityList) {
        this.timeOfEntry = timeOfEntry;
        this.activityList = activityList;
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

    public List<Activity> getActivityList() {
        return activityList;
    }

    public void setActivityList(List<Activity> activityList) {
        this.activityList = activityList;
    }
}
