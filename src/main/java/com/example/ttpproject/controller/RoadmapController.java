package com.example.ttpproject.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ttpproject.model.Task;
import com.example.ttpproject.service.RoadmapService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
// Method (e.g., post, get) is not needed here as it is just a generic request
@RequestMapping("/roadmap")
public class RoadmapController {

    // Do not have to explicitly initialise this as Spring Boot handles it
    private RoadmapService roadmapService;

    @Autowired
    public RoadmapController(RoadmapService roadmapService) {this.roadmapService = roadmapService;}

    @PostMapping("/toggle-task")
    public ResponseEntity<String> toggleTask(@RequestBody Map<String, String> body,
                                             @AuthenticationPrincipal UserDetails userDetails) {
        String title = body.get("title");
        String email = userDetails.getUsername();
        Task task = roadmapService.toggleIsCompleted(email, title);
        return task != null
                ? ResponseEntity.ok("Toggled task: " + title)
                : ResponseEntity.badRequest().body("Task not found");
    }

    // This is for debugging purposes
    @GetMapping("/roadmap-json")
    // ResponseEntity is a generic class to represent the HTTP response. You can set custom HTTP status and set headers
    // Do not use ResponseEntity<String> as it would be considered a plain string and not a JSON object
    public ResponseEntity<Object> printRoadmapAsJson() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(roadmapService.getRoadmap());
            System.out.println(json);
            return ResponseEntity.ok(json);
        } catch (JsonProcessingException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to convert roadmap to JSON");
        }
    }
}
