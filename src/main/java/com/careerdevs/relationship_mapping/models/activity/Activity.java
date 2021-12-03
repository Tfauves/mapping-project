package com.careerdevs.relationship_mapping.models.activity;

import com.careerdevs.relationship_mapping.models.activityType.ActivityType;

import javax.persistence.*;
import java.time.Duration;

@Entity
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Duration duration;

    @OneToOne
    private ActivityType activityType;

    public Activity() {}

    public Activity(Duration duration, ActivityType activityType) {
        this.duration = duration;
        this.activityType = activityType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Duration getDuration() {
        return duration;
    }


    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public ActivityType getActivityType() {
        return activityType;
    }

    public void setActivityType(ActivityType activityType) {
        this.activityType = activityType;
    }
}
