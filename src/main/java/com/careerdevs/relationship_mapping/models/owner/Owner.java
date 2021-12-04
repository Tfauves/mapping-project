package com.careerdevs.relationship_mapping.models.owner;

import com.careerdevs.relationship_mapping.models.Journal;
import com.careerdevs.relationship_mapping.models.dog.Dog;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
public class Owner {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String email;

    @OneToOne
    private Journal journal;

    @OneToMany
    @JoinColumn(name = "human_id", referencedColumnName = "id")

    @JsonIgnoreProperties("human")

    private List<Dog> dog;

    public Owner() {}

    public Owner(String name, String email) {
        this.name = name;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Dog> getDog() {
        return dog;
    }

    public void setDog(List<Dog> dog) {
        this.dog = dog;
    }
}
