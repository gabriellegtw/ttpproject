package com.example.ttpproject.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // primary key for Task entity
    private String title;
    private String skill;
    private Date endDate;
    private boolean isCompleted;

    public Task() {
        // nothing
    }

    @JsonCreator
    public Task(
            @JsonProperty("title") String title,
            @JsonProperty("skill") String skill,
            @JsonProperty("endDate") Date endDate,
            @JsonProperty("isCompleted") boolean isCompleted
    ) {
        this.title = title;
        this.skill = skill;
        this.endDate = endDate;
        this.isCompleted = isCompleted;
    }

    // To serialise something (i.e changing Java object to JSON or some other format)
    // You need to add getter methods because Jackson needs to be able to access the fields
    // The names of the getter method is important in denoting the name of the fields in json
    public String getTitle() {
        return title;
    }

    public String getSkill() {
        return skill;
    }

    public Date getEndDate() {
        return endDate;
    }

    public boolean getIsCompleted() {return isCompleted;}

    public void toggleIsCompleted() {isCompleted = !isCompleted;}
}
