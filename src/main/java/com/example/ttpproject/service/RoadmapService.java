package com.example.ttpproject.service;

import org.springframework.stereotype.Service;

import com.example.ttpproject.model.Roadmap;
import com.example.ttpproject.model.Task;
import com.example.ttpproject.model.User;
import com.example.ttpproject.repository.UserRepository;

// Have to include this for Java to recognise that it has to be autowired in the controller
// This @Service tells Spring Boot that this would be a singleton
@Service
public class RoadmapService {

    // Spring Boot will inject this in other classes
    private Roadmap roadmap = new Roadmap();

    private final UserRepository userRepository;

    public RoadmapService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Task findTaskByTitle(String title) {
        if (roadmap == null) return null;
        return roadmap.getTasks().stream()
                .filter(task -> task.getTitle().equals(title))
                .findFirst()
                .orElse(null);
    }

    // Change the status just by using the title of the task
    public Task toggleIsCompleted(String email, String title) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Task task = findTaskByTitle(title);
        task.toggleIsCompleted();
        userRepository.save(user);
        return task;
    }

    public Roadmap getRoadmap() {
        return roadmap;
    }

    public void setRoadmap(Roadmap roadmap) {
        this.roadmap = roadmap;
    }
}
