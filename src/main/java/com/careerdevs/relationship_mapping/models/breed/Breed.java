package com.careerdevs.relationship_mapping.models.breed;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Breed {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String breedGroup;

    public Breed() {}

    public Breed(String name, String breedGroup) {
        this.name = name;
        this.breedGroup = breedGroup;
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

    public String getBreedGroup() {
        return breedGroup;
    }

    public void setBreedGroup(String breedGroup) {
        this.breedGroup = breedGroup;
    }
}
