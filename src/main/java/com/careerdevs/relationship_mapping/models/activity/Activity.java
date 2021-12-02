package com.careerdevs.relationship_mapping.models.activity;

import com.careerdevs.relationship_mapping.models.activityType.ActivityType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long duration;


    private ActivityType activityType;

    public Activity() {}

    public Activity(Long duration, ActivityType activityType) {
        this.duration = duration;
        this.activityType = activityType;
    }

}
