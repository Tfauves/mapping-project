package com.careerdevs.relationship_mapping.models.activity;

import com.careerdevs.relationship_mapping.models.activityType.ActivityType;

import javax.persistence.*;

@Entity
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long durationMins;

    @OneToOne
    private ActivityType activityType;

    public Activity() {}

    public Activity(Long durationMins, ActivityType activityType) {
        this.durationMins = durationMins;
        this.activityType = activityType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDurationMins() {
        return durationMins;
    }


    public void setDurationMins(Long durationMins) {
        this.durationMins = durationMins;
    }

    public ActivityType getActivityType() {
        return activityType;
    }

    public void setActivityType(ActivityType activityType) {
        this.activityType = activityType;
    }
}
