package com.example.ttpproject.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.ttpproject.model.Roadmap;
import com.example.ttpproject.model.Task;

@ExtendWith(MockitoExtension.class)
class RoadmapServiceTest {

    private RoadmapService roadmapService;

    @BeforeEach
    void setUp() {
        roadmapService = new RoadmapService();
    }

    @Test
    void testFindTaskByTitle() {
        Task task = new Task("SQL", "Programming", new Date(), false);
        Roadmap roadmap = new Roadmap(new ArrayList<>(Arrays.asList(task)));
        roadmapService.setRoadmap(roadmap);

        Task foundTask = roadmapService.findTaskByTitle("SQL");
        assertEquals(task, foundTask);
    }

    @Test
    void testToggleIsCompleted() {
        Task task = new Task("SQL", "Programming", new Date(), false);
        Roadmap roadmap = new Roadmap(new ArrayList<>(Arrays.asList(task)));
        roadmapService.setRoadmap(roadmap);

        Task foundTask = roadmapService.toggleIsCompleted("test", "SQL");
        assertTrue(foundTask.getIsCompleted());
    }

}