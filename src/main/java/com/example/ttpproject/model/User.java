package com.example.ttpproject.model;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    private String careerStage;
    private String skills;
    private String goals;
    private String time;

    @OneToOne(cascade = CascadeType.ALL)
    private Roadmap roadmap;

    public User() {}

    public User(String email, String password, String careerStage, String skills, String goals, String time) {
        this.email = email;
        this.password = password;
        this.careerStage = careerStage;
        this.skills = skills;
        this.goals = goals;
        this.time = time;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Roadmap getRoadmap() {
        return roadmap;
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
