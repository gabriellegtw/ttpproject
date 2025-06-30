package com.example.ttpproject.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.ttpproject.model.Roadmap;
import com.example.ttpproject.model.Task;

@ExtendWith(MockitoExtension.class)
public class ProgressServiceTest {

    @Mock
    private RoadmapService roadmapService;

    @InjectMocks
    private ProgressService progressService;

    @Test
    void testGetNumberOfCompleted() {
        List<Task> tasks = List.of(
                new Task("Java", "Programming", new Date(), true),
                new Task("SQL", "Programming", new Date(), false),
                new Task("Python", "Programming", new Date(), true)
        );

        Roadmap mockRoadmap = new Roadmap(tasks);
        when(roadmapService.getRoadmap()).thenReturn(mockRoadmap);
        long completed = progressService.getNumberOfCompleted();

        assertEquals(2, completed);
    }

    @Test
    void testGetNumberOfUncompleted() {
        List<Task> tasks = List.of(
                new Task("Java", "Programming", new Date(), true),
                new Task("SQL", "Programming", new Date(), false),
                new Task("Python", "Programming", new Date(), true)
        );

        Roadmap mockRoadmap = new Roadmap(tasks);
        when(roadmapService.getRoadmap()).thenReturn(mockRoadmap);
        long uncompleted = progressService.getNumberOfUncompleted();

        assertEquals(1, uncompleted);
    }

    @Test
    void testGetCompletionPercentage() {
        List<Task> tasks = List.of(
                new Task("Java", "Programming", new Date(), true),
                new Task("SQL", "Programming", new Date(), false),
                new Task("Python", "Programming", new Date(), true)
        );

        Roadmap mockRoadmap = new Roadmap(tasks);
        when(roadmapService.getRoadmap()).thenReturn(mockRoadmap);
        long percentage = progressService.getCompletionPercentage();

        assertEquals(67, percentage);
    }

    @Test
    void testGetStrongestSkill() {
        List<Task> tasks = List.of(
                new Task("Java", "Programming", new Date(), true),
                new Task("Relational databases", "Databases", new Date(), false),
                new Task("Python", "Programming", new Date(), true)
        );

        Roadmap mockRoadmap = new Roadmap(tasks);
        when(roadmapService.getRoadmap()).thenReturn(mockRoadmap);
        String strongestSkill = progressService.getStrongestSkill();

        assertEquals("Programming", strongestSkill);
    }

    @Test
    void testGetWeakestSkill() {
        List<Task> tasks = List.of(
                new Task("Java", "Programming", new Date(), true),
                new Task("Relational databases", "Databases", new Date(), false),
                new Task("Python", "Programming", new Date(), true)
        );

        Roadmap mockRoadmap = new Roadmap(tasks);
        when(roadmapService.getRoadmap()).thenReturn(mockRoadmap);
        String weakestSkill = progressService.getWeakestSkill();

        assertEquals("Databases", weakestSkill);
    }
}
