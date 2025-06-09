package com.example.ttpproject.model;
import jakarta.persistence.Entity;

// TODO: Add this for DB later
//@Entity
public class User {
    private Long id;
    private String name;
    private String email;
    private String password;
    private String careerStage;
    private String skills;
    private String goals;
    private String time;
    private Roadmap roadmap;

    public User(String careerStage, String skills, String goals, String time) {
        this.careerStage = careerStage;
        this.skills = skills;
        this.goals = goals;
        this.time = time;
        this.roadmap = null;
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

    public void setRoadmap(Roadmap roadmap) {
        this.roadmap = roadmap;
    }
}
