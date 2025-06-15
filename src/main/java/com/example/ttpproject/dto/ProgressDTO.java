package com.example.ttpproject.dto;

import lombok.Data;

@Data
public class ProgressDTO {
    private long completedTasks;
    private long uncompletedTasks;
    private long completionPercentage;
    private String strongestSkill;
    private String weakestSkill;

    public ProgressDTO(long completedTasks, long uncompletedTasks, long completionPercentage, String strongestSkill, String weakestSkill) {
        this.completedTasks = completedTasks;
        this.uncompletedTasks = uncompletedTasks;
        this.completionPercentage = completionPercentage;
        this.strongestSkill = strongestSkill;
        this.weakestSkill = weakestSkill;
    }

}

