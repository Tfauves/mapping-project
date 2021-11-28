package com.careerdevs.relationship_mapping.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;

import javax.persistence.*;

@Entity
public class Dog {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Integer age;
    private Integer weight;

    @ManyToOne
    @JoinColumn(name = "dog_id", referencedColumnName = "id")
//    @JsonIgnore
    @JsonIncludeProperties("id")
    private User human;

    public Dog() {}

    public Dog(String name, Integer age, Integer weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public User getHuman() {
        return human;
    }

    public void setHuman(User human) {
        this.human = human;
    }
}
