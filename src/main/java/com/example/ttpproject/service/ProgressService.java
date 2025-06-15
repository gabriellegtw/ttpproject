package com.example.ttpproject.service;

import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.ttpproject.model.Roadmap;
import com.example.ttpproject.model.Task;

@Service
public class ProgressService {
    private final RoadmapService roadmapService;

    public ProgressService(RoadmapService roadmapService) {
        this.roadmapService = roadmapService;
    }

    public long getNumberOfCompleted() {
        Roadmap rm = roadmapService.getRoadmap();

        // Collections can be streamed
        return rm.getTasks().stream()
                .filter(task -> task.isCompleted())
                .count();
    }

    public long getNumberOfUncompleted() {
        Roadmap rm = roadmapService.getRoadmap();

        // Collections can be streamed
        return rm.getTasks().stream()
                .filter(task -> !task.isCompleted())
                .count();
    }

    public long getCompletionPercentage() {
        Roadmap rm = roadmapService.getRoadmap();
        long total = rm.getTasks().size();

        return (this.getNumberOfCompleted() / total) * 100;
    }

    public String getStrongestSkill() {
        Roadmap rm = roadmapService.getRoadmap();

        return rm.getTasks().stream()
                .filter(task -> task.isCompleted())
                // This collects the tasks into a Map with their skill and count
                // Map itself does not have a stream method
                .collect(Collectors.groupingBy(
                        Task::getSkill,
                        Collectors.counting()
                ))
                // Convert it into an entrySet so we can stream it
                // entrySet is a Set that contains key value pairs
                .entrySet()
                .stream()
                // The argument is a comparator
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("-");
    }

    public String getWeakestSkill() {
        Roadmap rm = roadmapService.getRoadmap();

        return rm.getTasks().stream()
                .filter(task -> !task.isCompleted())
                .collect(Collectors.groupingBy(
                        Task::getSkill,
                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("-");
    }
}
