package com.careerdevs.relationship_mapping.models.activity;

import com.careerdevs.relationship_mapping.models.activityType.ActivityType;

import javax.persistence.*;

@Entity
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long duration;

    @OneToOne
    private ActivityType activityType;

    public Activity() {}

    public Activity(Long duration, ActivityType activityType) {
        this.duration = duration;
        this.activityType = activityType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public ActivityType getActivityType() {
        return activityType;
    }

    public void setActivityType(ActivityType activityType) {
        this.activityType = activityType;
    }
}
