package com.example.ttpproject.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ttpproject.dto.ProgressDTO;
import com.example.ttpproject.service.ProgressService;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
// Method (e.g., post, get) is not needed here as it is just a generic request
@RequestMapping("/progress")
public class ProgressController {
    private final ProgressService progressService;

    public ProgressController(ProgressService progressService) {
        this.progressService = progressService;
    }

    // This is for debugging purposes
    @GetMapping("/get-progress")
    public ResponseEntity<ProgressDTO> getProgress() {
        long completedTasks = progressService.getNumberOfCompleted();
        long uncompletedTasks = progressService.getNumberOfUncompleted();
        long completionPercentage = progressService.getCompletionPercentage();
        String strongestSkill = progressService.getStrongestSkill();
        String weakestSkill = progressService.getWeakestSkill();

        ProgressDTO progress = new ProgressDTO(completedTasks, uncompletedTasks, completionPercentage, strongestSkill, weakestSkill);
        return ResponseEntity.ok(progress);
    }
}
