package com.example.ttpproject.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Roadmap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // This means that the roadmap has many tasks
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    // This means that there is a foreign key column called roadmap_id to link back to Roadmap
    @JoinColumn(name = "roadmap_id")
    // This annotation exposes the field as a JSON so no getter is needed for Jackson to work
    @JsonProperty("tasks")
    private List<Task> tasks;

    public Roadmap() {
        // nothing
    }

    public Roadmap(List<Task> tasks) {
        this.tasks = tasks;
    }

    public List<Task> getTasks() {
        return tasks;
    }
}
