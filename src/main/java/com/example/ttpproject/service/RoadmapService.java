package com.example.ttpproject.service;

import org.springframework.stereotype.Service;

import com.example.ttpproject.model.Roadmap;
import com.example.ttpproject.model.Task;

// Have to include this for Java to recognise that it has to be autowired in the controller
// This @Service tells Spring Boot that this would be a singleton
@Service
public class RoadmapService {

    // Spring Boot will inject this in other classes
    private Roadmap roadmap = new Roadmap();

    public Task findTaskByTitle(String title) {
        if (roadmap == null) return null;
        return roadmap.getTasks().stream()
                .filter(task -> task.getTitle().equals(title))
                .findFirst()
                .orElse(null);
    }

    // Change the status just by using the title of the task
    public Task toggleIsCompleted(String title) {
        Task task = findTaskByTitle(title);
        task.toggleIsCompleted();
        return task;
    }

    public Roadmap getRoadmap() {
        return roadmap;
    }

    public void setRoadmap(Roadmap roadmap) {
        this.roadmap = roadmap;
    }
}
