package com.example.ttpproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ttpproject.model.Roadmap;

public interface RoadmapRepository extends JpaRepository<Roadmap, Long> {
    // JpaRepository provides CRUD methods
}
