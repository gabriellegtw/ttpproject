package com.example.ttpproject.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Roadmap {
    // This annotation exposes the field as a JSON so no getter is needed for Jackson to work
    @JsonProperty("tasks")
    private List<Task> tasks;

    public Roadmap(List<Task> tasks) {
        this.tasks = tasks;
    }
}
