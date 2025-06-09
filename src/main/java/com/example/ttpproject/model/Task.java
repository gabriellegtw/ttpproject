package com.example.ttpproject.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Task {
    private String title;
    private String skill;
    private Date endDate;

    public Task() {
        // nothing
    }

    @JsonCreator
    public Task(
            @JsonProperty("title") String title,
            @JsonProperty("skill") String skill,
            @JsonProperty("endDate") Date endDate
    ) {
        this.title = title;
        this.skill = skill;
        this.endDate = endDate;
    }

//    public Task(String title, String skill, Date endDate) {
//        this.title = title;
//        this.skill = skill;
//        this.endDate = endDate;
//    }

    // To serialise something (i.e changing Java object to JSON or some other format)
    // You need to add getter methods because Jackson needs to be able to access the fields
    public String getTitle() {
        return title;
    }

    public String getSkill() {
        return skill;
    }

    public Date getEndDate() {
        return endDate;
    }
}
