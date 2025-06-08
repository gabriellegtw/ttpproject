package com.example.ttpproject.model;
import jakarta.persistence.Entity;

// TODO: Add this for DB later
//@Entity
public class User {
    private Long id;
    private String name;
    private String email;
    private String password;
    private final String careerStage;
    private final String skills;
    private final String goals;
    private final String time;

    public User(String careerStage, String skills, String goals, String time) {
        this.careerStage = careerStage;
        this.skills = skills;
        this.goals = goals;
        this.time = time;
    }

    public String getCareerStage() {
        return careerStage;
    }

    public String getSkills() {
        return skills;
    }

    public String getGoals() {
        return goals;
    }

    public String getTime() {
        return time;
    }
}
