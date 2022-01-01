package com.careerdevs.relationship_mapping.models.activity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Activity {
    @Id
    @GeneratedValue
    private Long id;
    private String action;
//    private String duration;
//    private String goal;

    public Activity() {}

    public Activity(String action) {
        this.action = action;
//        this.duration = duration;
//        this.goal = goal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

//    public String getDuration() {
//        return duration;
//    }
//
//    public void setDuration(String duration) {
//        this.duration = duration;
//    }
//
//    public String getGoal() {
//        return goal;
//    }
//
//    public void setGoal(String goal) {
//        this.goal = goal;
//    }
}
